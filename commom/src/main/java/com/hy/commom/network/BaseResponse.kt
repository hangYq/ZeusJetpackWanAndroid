package com.hy.commom.network

import kotlinx.coroutines.coroutineScope

open class BaseResponse {
	// 处理异常 code
	suspend fun <T : Any> executeResponse(response: BaseResponseModel<T>): BaseResult<T> {
		return try {
			coroutineScope {
				when (response.errorCode) {
					0 -> BaseResult.Success(response.data)
					else -> BaseResult.Error(
						CustomException.BusinessException(
							response.errorCode, response
								.errorMsg
						),
					)
				}
			}
		} catch (e: Exception) {
			BaseResult.Error(e)
		}
	}
}