package com.priyo.newsapp.model

import com.priyo.newsapp.model.Article

data class ResponseModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)