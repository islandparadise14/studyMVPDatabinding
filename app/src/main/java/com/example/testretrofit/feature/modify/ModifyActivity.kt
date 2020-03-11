package com.example.testretrofit.feature.modify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.testretrofit.R
import com.example.testretrofit.const.GlobalConst
import com.example.testretrofit.databinding.ActivityModifyBinding
import com.example.testretrofit.utils.showShortToast

class ModifyActivity : AppCompatActivity(), ModifyContract.View {
    private lateinit var mBinding: ActivityModifyBinding
    lateinit var presenter: ModifyPresenter
    var memoId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        initSetting()
    }

    private fun setDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_modify)
        mBinding.activity = this
    }

    private fun initSetting() {
        presenter = ModifyPresenter(this)
        val getIntent = intent
        memoId = getIntent.getIntExtra(GlobalConst.MEMOID, -1)
        presenter.getMemo(memoId)
    }

    override fun setText(title: String, content: String) {
        mBinding.titleModify.setText(title)
        mBinding.contentModify.setText(content)
    }

    override fun toastMessage(message: String) {
        showShortToast(this, message)
    }

    fun modifyButtonClicked() {
        val title = mBinding.titleModify.text
        val content = mBinding.contentModify.text
        if (title.isNotEmpty() && content.isNotEmpty()) {
            presenter.submitModify(memoId, title.toString(), content.toString())
        } else {
            toastMessage(getString(R.string.memo_post_hint))
        }
    }

    override fun finishPost() {
        toastMessage(getString(R.string.memo_modify_complete))
        finish()
    }
}
