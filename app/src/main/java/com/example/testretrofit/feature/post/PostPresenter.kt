package com.example.testretrofit.feature.post

import android.annotation.SuppressLint
import com.example.testretrofit.network.usecase.PostMemoUseCase
import timber.log.Timber

class PostPresenter(override var view: PostContract.View) : PostContract.Presenter {
    private val postMemoUseCase = PostMemoUseCase()

    @SuppressLint("CheckResult")
    override fun submitPost(title: String, content: String) {
        postMemoUseCase.postMemo(title, content)
            .subscribe({
                view.finishPost()
            }, {
                view.toastMessage("작성 오류")
                Timber.e(it.localizedMessage)
            })
    }
}