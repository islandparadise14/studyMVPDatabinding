package com.example.testretrofit.network.usecase

import com.example.testretrofit.network.RetrofitUtil
import com.example.testretrofit.network.service.MemoService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DeleteMemoUseCase {
    private val mMemoService = RetrofitUtil.retrofitBuilder()
        .create(MemoService::class.java)
    fun deleteMemo(memoId: Int): Observable<String> =
        mMemoService.deleteMemo(memoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}