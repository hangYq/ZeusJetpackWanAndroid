package com.hy.module_home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy.commom.network.BaseResult
import com.hy.module_home.repository.HomeRepository
import com.hy.module_home.response.BannerItem
import kotlinx.coroutines.launch

class BannerViewModel : ViewModel() {
	private val banners = MutableLiveData<List<BannerItem>?>()

	private val  homeRepository by lazy { HomeRepository() }

	fun getBanners():MutableLiveData<List<BannerItem>?> {
		return banners
	}

	fun fetchBanners() {
		viewModelScope.launch {
			when(val result = homeRepository.fetchBanners()) {
				is BaseResult.Success -> {
					banners.postValue(result.data)
				}
				is BaseResult.Error	-> {

				}
			}
		}
	}
}