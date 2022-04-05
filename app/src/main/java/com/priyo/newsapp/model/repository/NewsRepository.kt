package com.priyo.newsapp.model.repository

import com.priyo.newsapp.NewsResponseInstance
import com.priyo.newsapp.model.ResponseModel
import com.priyo.newsapp.util.Resource
import retrofit2.Response

/**
 * Created by Priyabrata Naskar on 05-04-2022.
 */
class NewsRepository {
    suspend fun getTopNews() =
        NewsResponseInstance.apiInstance.getTopNews()
}