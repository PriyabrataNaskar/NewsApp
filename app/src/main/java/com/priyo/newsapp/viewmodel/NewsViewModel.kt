package com.priyo.newsapp.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.*
import android.os.Build
import android.util.Log
import androidx.lifecycle.*
import com.priyo.newsapp.model.data.ResponseModel
import com.priyo.newsapp.model.repository.NewsRepository
import com.priyo.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Created by Priyabrata Naskar on 05-04-2022.
 */
class NewsViewModel(
    val newsRepository: NewsRepository,
    application: Application
    ): AndroidViewModel(application) {
    private val _topNews: MutableLiveData<Resource<ResponseModel>> = MutableLiveData()
    val topNews: LiveData<Resource<ResponseModel>> get() = _topNews

    private val _isInterNetAvailable: MutableLiveData<Boolean> = MutableLiveData()
    private val isInterNetAvailable: LiveData<Boolean> get() = _isInterNetAvailable

    private val TAG: String = "ViewModel"
    init {
        getTopNews()
    }

    private fun getTopNews(){
        if (!hasInternetConnection()){
            _topNews.postValue(Resource.Error("No Internet Connection"))
            Log.e(TAG,"No Internet Connection")
            return
        }
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

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(TRANSPORT_WIFI) -> true
            capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
            else -> false
        }
        return false
    }
}