package com.hy.zeusjetpackwanandroid.api

import retrofit2.http.GET
import retrofit2.http.Path

interface HomeServices {
	@GET("/article/list/{page}/json")
	suspend fun getHomeArticle(@Path("page") page: Int): Any
}
