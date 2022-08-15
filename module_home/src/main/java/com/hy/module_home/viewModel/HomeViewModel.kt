package com.hy.module_home.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.hy.commom.network.BaseResult
import com.hy.module_home.repository.HomeRepository
import com.hy.module_home.bean.Articles
import com.hy.module_home.bean.BannerItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
	private val banners = MutableLiveData<List<BannerItem>?>()
	private val articles = MutableLiveData<Articles>()

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



	fun fetchArticles():Flow<PagingData<Articles.Article>> {
		return homeRepository.fetchArticlePageData().cachedIn(viewModelScope)
//		viewModelScope.launch {
//			when(val result = homeRepository.fetchArticles()) {
//				is BaseResult.Success -> {
//					result.data?.let {
//						articles.postValue(it)
//					}
//				}
//				is BaseResult.Error -> {
//
//				}
//			}
//		}
	}
}