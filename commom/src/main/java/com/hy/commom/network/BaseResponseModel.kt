package com.hy.commom.network


data class BaseResponseModel<T>(
	var errorCode: Int = 0,
	var errorMsg: String = "",
	var data: T? = null
)
