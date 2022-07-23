package com.hy.zeusjetpackwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hy.zeusjetpackwanandroid.databinding.ActivityMainBinding
import com.hy.zeusjetpackwanandroid.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	private val homeViewModel by lazy { HomeViewModel() }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
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
	}
}