package com.hy.zeusjetpackwanandroid.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy.commom.network.BaseResult
import com.hy.zeusjetpackwanandroid.repository.HomeRepository
import com.hy.zeusjetpackwanandroid.response.HomeArticle
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel(){
	private val  homeRepository by lazy { HomeRepository() }
	val currentName: MutableLiveData<HomeArticle> by lazy {
		MutableLiveData<HomeArticle>()
	}

	fun getHomeData(page:Int) {
		viewModelScope.launch {
			when(val result = homeRepository.fetchHomeData(page)) {
				is BaseResult.Success -> {
					Log.d("ddddd","${result.data?.curPage}")
					currentName.postValue(result.data)
				}
				is BaseResult.Error	-> {

				}
			}
		}
	}
}