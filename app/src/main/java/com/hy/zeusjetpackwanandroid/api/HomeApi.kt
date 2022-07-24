package com.hy.zeusjetpackwanandroid.api

import com.hy.commom.network.BaseResponseModel
import com.hy.zeusjetpackwanandroid.response.HomeArticle
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {
	@GET("/article/list/{page}/json")
	suspend fun getHomeArticle(@Path("page") page: Int): BaseResponseModel<HomeArticle>
//	suspend fun getHomeArticle(@Path("page") page: Int): Any
}
