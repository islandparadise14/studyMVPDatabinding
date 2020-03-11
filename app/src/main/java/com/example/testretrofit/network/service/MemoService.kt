package com.example.testretrofit.network.service

import com.example.testretrofit.data.reponse.MemoDefaultResponse
import com.example.testretrofit.data.reponse.MemoResponse
import com.example.testretrofit.data.request.MemoModifyRequest
import com.example.testretrofit.data.request.MemoRequest
import io.reactivex.Observable
import retrofit2.http.*

interface MemoService {
    @GET("/memo")
    fun getMemoList(): Observable<ArrayList<MemoResponse>>

    @GET("/memo/{id}")
    fun getMemo(@Path("id") memoId: Int): Observable<MemoResponse>

    @POST("/memo")
    fun postMemo(@Body memoRequest: MemoRequest): Observable<MemoDefaultResponse>

    @PUT("/memo/{id}")
    fun putMemo(@Path("id") memoId: Int, @Body memoModifyRequest: MemoModifyRequest): Observable<MemoDefaultResponse>

    @DELETE("/memo/{id}")
    fun deleteMemo(@Path("id") memoId: Int): Observable<String>
}