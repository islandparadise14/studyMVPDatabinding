package com.example.testretrofit.data.request

import com.fasterxml.jackson.annotation.JsonProperty

data class MemoRequest (
    @JsonProperty("title") var title: String,
    @JsonProperty("content") var content: String
)