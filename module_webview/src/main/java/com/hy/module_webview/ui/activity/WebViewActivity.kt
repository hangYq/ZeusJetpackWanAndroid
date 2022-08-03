package com.hy.module_webview.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hy.commom.config.ArouterConfig
import com.hy.module_webview.databinding.ActivityWebviewBinding


@Route(path = ArouterConfig.COMMON_WEBVIEW)
class WebViewActivity : AppCompatActivity() {
	@Autowired
	@JvmField var path: String? = null

	private lateinit var mBinding: ActivityWebviewBinding
	private lateinit var mWebView: WebView

	override fun onCreate(savedInstanceState: Bundle?) {
		ARouter.getInstance().inject(this)
		super.onCreate(savedInstanceState)
		mBinding = ActivityWebviewBinding.inflate(layoutInflater)
		val view = mBinding.root
		setContentView(view)
		initWebView()
	}

	@SuppressLint("SetJavaScriptEnabled")
	private fun initWebView() {
		mWebView = WebView(this)
		mBinding.webviewContainer.addView(mWebView)
		val webSetting = mWebView.settings
		webSetting.domStorageEnabled = true
		webSetting.useWideViewPort = true
		webSetting.loadWithOverviewMode = true
		webSetting.javaScriptEnabled = true

		mWebView.webViewClient = object : WebViewClient() {
			override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
				if (url == null) {
					return false
				}
				try {
					if (url.startsWith("weixin://") || url.startsWith("jianshu://")||url.startsWith
							("bytedance://")) {
						Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
							startActivity(this)
						}
						return true
					}
				} catch (e: Exception) {
					return true
				}

				view?.loadUrl(url)
				return true
			}
		}

		mWebView.webChromeClient = object : WebChromeClient() {
			override fun onProgressChanged(view: WebView?, newProgress: Int) {
				if(newProgress < 100) {
					mBinding.progressBar.let {
						it.visibility = View.VISIBLE
						it.progress = newProgress
					}
				} else {
					mBinding.progressBar.visibility = View.GONE
				}
			}
		}
		mWebView.loadUrl(path ?: "")
	}

}