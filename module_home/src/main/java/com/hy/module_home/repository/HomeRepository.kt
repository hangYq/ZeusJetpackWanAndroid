package com.hy.module_home.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hy.commom.network.BaseResponse
import com.hy.commom.network.BaseResult
import com.hy.commom.network.ZeusRetrofit
import com.hy.module_home.api.HomeApi
import com.hy.module_home.bean.Articles
import com.hy.module_home.bean.BannerItem
import com.hy.module_home.pagesource.ArticlePageSource
import kotlinx.coroutines.flow.Flow

class HomeRepository : BaseResponse() {
	// 创建 service 实例
	private val zeusRetrofit = ZeusRetrofit.getServices(HomeApi::class.java)

	private val pageSize = 5

	//	获取首页数据
	suspend fun fetchBanners(): BaseResult<List<BannerItem>> {
		return executeResponse(zeusRetrofit.fetchBanners())
	}

	fun fetchArticlePageData(): Flow<PagingData<Articles.Article>> {
		return Pager(
			config = PagingConfig(pageSize = pageSize, prefetchDistance = pageSize * 5),
			pagingSourceFactory = { ArticlePageSource(zeusRetrofit) },
		).flow
	}
}