package com.hy.zeusjetpackwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hy.commom.config.ArouterConfig
import com.hy.zeusjetpackwanandroid.databinding.ActivityMainBinding
import com.hy.zeusjetpackwanandroid.viewmodel.HomeViewModel
class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	private val homeViewModel by lazy { HomeViewModel() }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		ARouter.getInstance().inject(this)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		initEvent()
	}

	private fun initEvent() {
		binding.retrofitBtn.setOnClickListener {
			homeViewModel.getHomeData(0)
			homeViewModel.currentName.observe(this) {
				binding.tvContent.text = it.curPage.toString()
			}
		}

		binding.btnNavigator.setOnClickListener {
			Log.d("6666666","ddddd")
			ARouter.getInstance().build(ArouterConfig.TEST_DETAIL).navigation()
		}
	}
}