package com.example.tvormoive.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("page") val page: Int,
    @SerializedName("result") val result: List<Result>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)