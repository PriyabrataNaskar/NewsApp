package com.priyo.newsapp

data class ResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)