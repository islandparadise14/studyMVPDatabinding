package com.example.testretrofit.feature.main

import com.example.testretrofit.data.reponse.MemoResponse

interface MainContract {
    interface View {
        fun updateMemo(list: ArrayList<MemoResponse>)

        fun refreshView()

        fun toastMessage(message: String)
    }

    interface Presenter {
        var view: View

        fun getMemoInfo()

        fun deleteMemo(memoId: Int)
    }
}