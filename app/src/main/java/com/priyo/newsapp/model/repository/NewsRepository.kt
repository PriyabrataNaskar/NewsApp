package com.priyo.newsapp.model.repository

import com.priyo.newsapp.model.api.NewsResponseInstance

/**
 * Created by Priyabrata Naskar on 05-04-2022.
 */
class NewsRepository {
    suspend fun getTopNews() =
        NewsResponseInstance.apiInstance.getTopNews()
}