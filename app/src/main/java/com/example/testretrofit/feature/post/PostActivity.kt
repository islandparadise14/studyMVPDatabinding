package com.example.testretrofit.feature.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.testretrofit.R
import com.example.testretrofit.databinding.ActivityPostBinding
import com.example.testretrofit.utils.showShortToast

class PostActivity : AppCompatActivity(), PostContract.View {
    private lateinit var mBinding: ActivityPostBinding
    lateinit var presenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        initSetting()
    }

    private fun setDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_post)
        mBinding.activity = this
    }

    private fun initSetting() {
        presenter = PostPresenter(this)
    }

    override fun toastMessage(message: String) = showShortToast(this, message)

    fun submitButtonClicked() {
        val title = mBinding.titleText.text
        val content = mBinding.contentText.text
        if (title.isNotEmpty() && content.isNotEmpty()) {
            presenter.submitPost(title = title.toString(), content = content.toString())
        } else {
            toastMessage(getString(R.string.memo_post_hint))
        }
    }

    override fun finishPost() {
        toastMessage(getString(R.string.memo_post_complete))
        finish()
    }
}
