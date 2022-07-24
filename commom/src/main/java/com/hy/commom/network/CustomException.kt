package com.hy.commom.network

sealed class CustomException(open val code: Int, override val message: String) :
	RuntimeException(message) {
	
	// 业务异常
	data class BusinessException(override val code: Int, override val message: String) :
		CustomException(code, message)
}