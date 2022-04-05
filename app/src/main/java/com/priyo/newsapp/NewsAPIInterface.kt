package com.priyo.newsapp

import com.priyo.newsapp.util.Constants.Companion.API_KEY
import com.priyo.newsapp.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Priyabrata Naskar on 04-04-2022.
 */
interface NewsAPIInterface {

    /**
     * Search for only top articles
     */
    @GET("v2/top-headlines")
    suspend fun getTopNews(@Query("apiKey") apiKey: String = API_KEY, @Query("page") pageNumber: Int = 1): Response<ResponseModel>
}