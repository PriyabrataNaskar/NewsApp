package com.priyo.newsapp.model.api

import com.priyo.newsapp.model.data.ResponseModel
import com.priyo.newsapp.util.Constants
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
    suspend fun getTopNews(
        @Query("apiKey") apiKey: String = Constants.API_KEY,
        @Query("page") pageNumber: Int = 1,
        @Query("country") countryCode: String = "us",
    ):
            Response<ResponseModel>
}