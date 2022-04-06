package com.priyo.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.priyo.newsapp.model.data.ResponseModel
import com.priyo.newsapp.model.repository.NewsRepository
import com.priyo.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Created by Priyabrata Naskar on 05-04-2022.
 */
class NewsViewModel(val newsRepository: NewsRepository): ViewModel() {
    private val _topNews: MutableLiveData<Resource<ResponseModel>> = MutableLiveData()
    val topNews: LiveData<Resource<ResponseModel>> get() = _topNews

    init {
        getTopNews()
    }

    private fun getTopNews(){
        viewModelScope.launch {
            _topNews.postValue(Resource.Loading())
            val response = newsRepository.getTopNews()
            _topNews.postValue(handleTopNews(response))
        }
    }

    private fun handleTopNews(response: Response<ResponseModel>): Resource<ResponseModel>{
        if (response.isSuccessful){
            response.body()?.let { responseResult->
                return Resource.Success(responseResult)
            }
        }
        return Resource.Error(response.message())
    }
}