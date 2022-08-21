package com.hy.module_project.api

import com.hy.commom.network.BaseResponseModel
import com.hy.module_project.bean.NavigationData
import retrofit2.http.GET
import com.hy.module_project.bean.SystemDataItem

interface ProjectApi {
	// 获取体系数据
	@GET("/tree/json")
	suspend fun fetchSystems(): BaseResponseModel<List<SystemDataItem>>

	// 获取导航数据
	@GET("/navi/json")
	suspend fun fetchNavigation(): BaseResponseModel<List<NavigationData>>
}
