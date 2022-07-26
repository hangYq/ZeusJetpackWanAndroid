package com.hy.module_home.repository

import com.hy.commom.network.BaseResponse
import com.hy.commom.network.BaseResult
import com.hy.commom.network.ZeusRetrofit
import com.hy.module_home.api.HomeApi
import com.hy.module_home.response.BannerItem

class HomeRepository: BaseResponse() {
	// 创建 service 实例
	private val zeusRetrofit = ZeusRetrofit.getServices(HomeApi::class.java)


	//	测试获取首页数据
	suspend fun fetchBanners(): BaseResult<List<BannerItem>> {
		return executeResponse(zeusRetrofit.fetchBanners())
	}
}