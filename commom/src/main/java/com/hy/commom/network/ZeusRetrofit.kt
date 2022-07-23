package com.hy.commom.network

import com.hy.commom.network.config.Config
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ZeusRetrofit {
	private var mRetrofit: Retrofit
	private var mOkHttpClient: OkHttpClient

	private fun getOkHttpClient(): OkHttpClient {
		// 优化
		val logging = HttpLoggingInterceptor()

		logging.level = HttpLoggingInterceptor.Level.BODY
		return OkHttpClient.Builder()
			.callTimeout(10, TimeUnit.SECONDS)
			.connectTimeout(10, TimeUnit.SECONDS)
			.readTimeout(10L, TimeUnit.SECONDS)
			.writeTimeout(10L, TimeUnit.SECONDS)
			.retryOnConnectionFailure(true)
			.followRedirects(true)
			.addInterceptor(logging)
			.build()
	}


	init {
		mOkHttpClient = getOkHttpClient()
		val moshi = Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.build()

		mRetrofit = Retrofit.Builder()
			.client(mOkHttpClient)
			.addConverterFactory(MoshiConverterFactory.create(moshi))
			.baseUrl(Config.baseUrl)
			.build()
	}

	fun <T> getServices (serviceClass: Class<T>):T {
		return mRetrofit.create(serviceClass)
	}
}