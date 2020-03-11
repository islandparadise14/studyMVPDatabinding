package com.example.testretrofit.network.usecase

import com.example.testretrofit.data.reponse.MemoResponse
import com.example.testretrofit.network.RetrofitUtil
import com.example.testretrofit.network.service.MemoService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetMemoUseCase {
    private val mMemoService = RetrofitUtil.retrofitBuilder()
        .create(MemoService::class.java)
    fun getMemo(memoId: Int): Observable<MemoResponse> =
        mMemoService.getMemo(memoId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}