package com.hy.module_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.hy.commom.config.ArouterConfig

@Route(path = ArouterConfig.TEST_DETAIL)
class HomeDetail : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_home_detail)
	}
}