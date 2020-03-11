package com.example.testretrofit.data.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Self (
    @JsonProperty("self") var self: String
)