package com.example.testretrofit.data.reponse

import com.example.testretrofit.data.entity.Self
import com.fasterxml.jackson.annotation.JsonProperty

data class MemoDefaultResponse (
    @JsonProperty("_links") var links: Self
)