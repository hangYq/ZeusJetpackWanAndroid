package com.hy.module_home.api

import com.hy.commom.network.BaseResponseModel
import com.hy.module_home.response.BannerItem
import retrofit2.http.GET

interface HomeApi {
	@GET("/banner/json")
	suspend fun fetchBanners(): BaseResponseModel<List<BannerItem>>
}