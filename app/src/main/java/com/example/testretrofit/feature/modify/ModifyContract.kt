package com.example.testretrofit.feature.modify

interface ModifyContract {
    interface View {
        fun setText(title: String, content: String)

        fun finishPost()

        fun toastMessage(message: String)
    }

    interface Presenter {
        var view: View

        fun getMemo(memoId: Int)

        fun submitModify(id: Int, title: String, content: String)
    }
}