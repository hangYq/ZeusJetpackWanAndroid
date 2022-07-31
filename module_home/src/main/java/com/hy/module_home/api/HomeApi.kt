package com.hy.module_home.api

import com.hy.commom.network.BaseResponseModel
import com.hy.module_home.bean.Articles
import com.hy.module_home.bean.BannerItem
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {
	// 获取首页 banner
	@GET("/banner/json")
	suspend fun fetchBanners(): BaseResponseModel<List<BannerItem>>

	// 获取首页文章列表
	@GET("/article/list/{page}/json")
	suspend fun fetchArticles(@Path("page")page :Int): BaseResponseModel<Articles>
}