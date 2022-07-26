// 版本号管理
object Versions {
	const val compileSdkVersion = 31
	const val targetSdkVersion = 31
	const val minSdkSdkVersion = 23

	const val lifeCycleVersion = "2.3.1"
	const val fragmentKtxVersion = "1.5.0"
	const val coroutinesVersion = "1.4.1"
	const val retrofitVersion = "2.9.0"
	const val okhttp3Version = "4.10.0"
	const val moshiVersion = "1.13.0"
	const val converterMoshiVersion = "2.4.0"
	const val loggingInterceptor = "4.10.0"
	const val arouterApiVersion = "1.5.2"
	const val arouterCompilerVersion = "1.5.2"
	const val navVersion = "2.5.0"
	const val youthBannerVersion = "2.2.2"
	const val glideVersion = "4.13.2"
}

// 三方库管理
object Libs {
	// lifeCycle 相关

	const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions
		.lifeCycleVersion}"
	const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleVersion}"
	const val viewModelSavedState = "androidx" +
					".lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifeCycleVersion}"

	// ktx
	const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"

	// coroutines
	const val kotlinxCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
	const val kotlinxCoroutinesAndroid ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

	// http
	const val retrofit ="com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
	const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3Version}"
	const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
	const val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.converterMoshiVersion}"
	const val loggingInterceptor ="com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
	const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"

	// 其他
	const val arouterApi = "com.alibaba:arouter-api:${Versions.arouterApiVersion}"
	const val arouterCompiler = "com.alibaba:arouter-compiler:${Versions.arouterCompilerVersion}"
	const val youthBanner = "io.github.youth5201314:banner:${Versions.youthBannerVersion}"
	const val glide ="com.github.bumptech.glide:glide:${Versions.glideVersion}"
	const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

	// nav
	const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
	const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

}