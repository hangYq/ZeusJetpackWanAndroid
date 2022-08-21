package com.hy.module_project.repository

import com.hy.commom.network.BaseResponse
import com.hy.commom.network.BaseResult
import com.hy.commom.network.ZeusRetrofit
import com.hy.module_project.api.ProjectApi
import com.hy.module_project.bean.NavigationData
import com.hy.module_project.bean.SystemDataItem



class ProjectRepository : BaseResponse() {
	// 创建 service 实例
	private val zeusRetrofit = ZeusRetrofit.getServices(ProjectApi::class.java)

	//	获取体系数据
	suspend fun fetchSystems(): BaseResult<List<SystemDataItem>> {
		return executeResponse(zeusRetrofit.fetchSystems())
	}

	//	获取导航数据
	suspend fun fetchNavigation(): BaseResult<List<NavigationData>> {
		return executeResponse(zeusRetrofit.fetchNavigation())
	}
}