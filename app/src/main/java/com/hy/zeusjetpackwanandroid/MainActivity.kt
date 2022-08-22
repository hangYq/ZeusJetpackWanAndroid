package com.hy.zeusjetpackwanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hy.module_home.ui.fragment.HomeFragment
import com.hy.module_my.ui.fragment.MyFragment
import com.hy.module_project.ui.fragment.ProjectFragment
import com.hy.zeusjetpackwanandroid.databinding.ActivityMainBinding
import com.hy.zeusjetpackwanandroid.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	private val homeViewModel by lazy { HomeViewModel() }

	private lateinit var navHostFragment: NavHostFragment
	private lateinit var bottomNav: BottomNavigationView
	private var mSelectedId = -1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		ARouter.getInstance().inject(this)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		setupBottomNavMenu()
//		initEvent()
	}

	private fun setupBottomNavMenu() {
		navHostFragment =
			supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
		val navController = navHostFragment.navController
		bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

		// 屏蔽长按吐司
		(bottomNav.getChildAt(0) as? ViewGroup)?.children?.forEach { it.setOnLongClickListener { true } }

		bottomNav.setupWithNavController(navController)
		bottomNav.setOnItemSelectedListener {
			val fragment: Fragment
			mSelectedId = it.itemId
			when (it.itemId) {
				R.id.homeFragment -> {
					fragment = HomeFragment()
					loadFragment(fragment)
					true
				}
				R.id.projectFragment -> {
					fragment = ProjectFragment()
					loadFragment(fragment)
					true
				}
				R.id.myFragment -> {
					fragment = MyFragment()
					loadFragment(fragment)
					true
				}
				else -> false
			}
		}
	}

	private fun loadFragment(fragment: Fragment) {
		// load fragment
		supportFragmentManager.beginTransaction()
			.replace(R.id.fragmentContainerView, fragment)
			.commit()
	}

//	private fun initEvent() {
//		binding.retrofitBtn.setOnClickListener {
//			homeViewModel.getHomeData(0)
//			homeViewModel.currentName.observe(this) {
//				binding.tvContent.text = it.curPage.toString()
//			}
//		}
//
//		binding.btnNavigator.setOnClickListener {
//			Log.d("6666666","ddddd")
//			ARouter.getInstance().build(ArouterConfig.TEST_DETAIL).navigation()
//		}
//	}
}
