package com.hy.zeusjetpackwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hy.commom.network.ZeusRetrofit
import com.hy.zeusjetpackwanandroid.api.HomeServices
import com.hy.zeusjetpackwanandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding;
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		initEvent()
	}

	private fun initEvent() {
		binding.retrofitBtn.setOnClickListener {
			GlobalScope.launch { // 在后台启动一个新的协程并继续
				val a = ZeusRetrofit.getServices(HomeServices::class.java).getHomeArticle(0)
			}
		}
	}

}