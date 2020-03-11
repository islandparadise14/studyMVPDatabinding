package com.example.testretrofit.feature.main

import android.annotation.SuppressLint
import com.example.testretrofit.network.usecase.DeleteMemoUseCase
import com.example.testretrofit.network.usecase.GetMemoListUseCase
import timber.log.Timber

class MainPresenter(override var view: MainContract.View) : MainContract.Presenter {
    private val getMemoListUseCase =
        GetMemoListUseCase()
    private val deleteMemoUseCase =
        DeleteMemoUseCase()

    @SuppressLint("CheckResult")
    override fun getMemoInfo() {
        getMemoListUseCase.getMemoList()
            .subscribe({
                view.updateMemo(it)
            }, {
                Timber.e(it.localizedMessage)
            })
    }

    @SuppressLint("CheckResult")
    override fun deleteMemo(memoId: Int) {
        deleteMemoUseCase.deleteMemo(memoId)
            .subscribe({
                view.refreshView()
                view.toastMessage(it)
            }, {
                Timber.e(it.localizedMessage)
            })
    }
}