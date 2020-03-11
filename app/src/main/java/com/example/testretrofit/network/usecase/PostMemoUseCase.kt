package com.example.testretrofit.network.usecase

import com.example.testretrofit.data.reponse.MemoDefaultResponse
import com.example.testretrofit.data.request.MemoRequest
import com.example.testretrofit.network.RetrofitUtil
import com.example.testretrofit.network.service.MemoService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostMemoUseCase {
    private val mMemoService = RetrofitUtil.retrofitBuilder()
        .create(MemoService::class.java)
    fun postMemo(title: String, content: String): Observable<MemoDefaultResponse> =
        mMemoService.postMemo(MemoRequest(title, content))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}