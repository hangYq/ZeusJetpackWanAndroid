package com.hy.zeusjetpackwanandroid.repository

import com.hy.commom.network.BaseResponse
import com.hy.commom.network.BaseResult
import com.hy.commom.network.ZeusRetrofit
import com.hy.zeusjetpackwanandroid.api.HomeApi
import com.hy.zeusjetpackwanandroid.response.HomeArticle

class HomeRepository: BaseResponse() {
	// 创建 service 实例
	private val zeusRetrofit = ZeusRetrofit.getServices(HomeApi::class.java)


	//	测试获取首页数据
	suspend fun fetchHomeData( page: Int): BaseResult<HomeArticle> {
		return executeResponse(zeusRetrofit.getHomeArticle(page))
	}
}