package com.example.testretrofit.feature.post

interface PostContract {
    interface View {
        fun finishPost()

        fun toastMessage(message: String)
    }

    interface Presenter {
        var view: View

        fun submitPost(title: String, content: String)
    }
}