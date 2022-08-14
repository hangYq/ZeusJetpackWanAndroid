package com.hy.module_project.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.hy.module_project.R
import com.hy.module_project.adapter.ViewPagerAdapter
import com.hy.module_project.databinding.FragmentNavigationBinding
import com.hy.module_project.databinding.FragmentProjectBinding

class ProjectFragment : Fragment() {
	private var _binding: FragmentProjectBinding? = null
	private val binding get() = _binding!!
	private lateinit var viewPagerAdapter: ViewPagerAdapter
	private lateinit var viewPager: ViewPager2
	private val tabs : List<String> = listOf("体系","导航")
	private val fragments: List<Fragment> = listOf(SystemFragment(), NavigationFragment())

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentProjectBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val tabLayout = binding.tabLayout
		viewPagerAdapter = ViewPagerAdapter(this,fragments)
		viewPager = binding.pager
		viewPager.adapter = viewPagerAdapter
		TabLayoutMediator(tabLayout, viewPager) { tab, position ->
			tab.text = tabs[position]
		}.attach()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}