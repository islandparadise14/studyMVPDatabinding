package com.example.testretrofit.feature.modify

import android.annotation.SuppressLint
import com.example.testretrofit.network.usecase.GetMemoUseCase
import com.example.testretrofit.network.usecase.PutMemoUseCase
import timber.log.Timber

class ModifyPresenter(override var view: ModifyContract.View) : ModifyContract.Presenter {
    private val getMemoUseCase = GetMemoUseCase()
    private val putMemoUseCase = PutMemoUseCase()

    @SuppressLint("CheckResult")
    override fun getMemo(memoId: Int) {
        getMemoUseCase.getMemo(memoId)
            .subscribe({
                view.setText(it.title, it.content)
            },{
                Timber.e(it.localizedMessage)
            })
    }

    @SuppressLint("CheckResult")
    override fun submitModify(id: Int, title: String, content: String) {
        putMemoUseCase.putMemo(id, title, content)
            .subscribe({
                view.finishPost()
            },{
                view.toastMessage("수정 오류")
                Timber.e(it.localizedMessage)
            })
    }
}