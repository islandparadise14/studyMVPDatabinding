package com.example.testretrofit.feature.main

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testretrofit.R
import com.example.testretrofit.const.GlobalConst
import com.example.testretrofit.data.reponse.MemoResponse
import com.example.testretrofit.databinding.ActivityMainBinding
import com.example.testretrofit.feature.modify.ModifyActivity
import com.example.testretrofit.feature.post.PostActivity
import com.example.testretrofit.utils.createDialogWithTitle
import com.example.testretrofit.utils.showShortToast

class MainActivity : AppCompatActivity(), MainContract.View {
    lateinit var mBinding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        initSetting()
    }

    private fun setDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.activity = this
    }

    private fun initSetting() {
        mBinding.swipeLayout.setOnRefreshListener {
            presenter.getMemoInfo()
        }
        presenter = MainPresenter(this)
        presenter.getMemoInfo()
    }

    private val clicked = { memeId: Int ->
        createDialogWithTitle(getString(R.string.modify_confirm), this,
            DialogInterface.OnClickListener { _, _ ->
                startActivityForResult(Intent(this, ModifyActivity::class.java)
                    .apply { putExtra(GlobalConst.MEMOID, memeId) }, 4000)
            })
    }

    private val longClicked = { memoId: Int ->
        createDialogWithTitle(getString(R.string.delete_confirm), this,
            DialogInterface.OnClickListener { _, _ ->
                presenter.deleteMemo(memoId)
            })
    }

    override fun updateMemo(list: ArrayList<MemoResponse>) {
        mBinding.swipeLayout.isRefreshing = false
        mBinding.memoListRecycler.adapter = MemoAdapter(list, clicked, longClicked)
        mBinding.memoListRecycler.layoutManager = LinearLayoutManager(this)
    }

    override fun toastMessage(message: String) = showShortToast(this, message)

    override fun refreshView() {
        presenter.getMemoInfo()
    }

    fun navigateToPost() = startActivityForResult(Intent(this, PostActivity::class.java), 3000)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.getMemoInfo()
    }
}
