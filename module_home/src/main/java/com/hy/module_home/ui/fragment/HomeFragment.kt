package com.hy.module_home.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hy.module_home.adapter.ImageAdapter
import com.hy.module_home.databinding.FragmentHomeBinding
import com.hy.module_home.response.BannerItem
import com.hy.module_home.viewModel.BannerViewModel
import com.youth.banner.Banner
import com.youth.banner.indicator.RoundLinesIndicator


class HomeFragment : Fragment() {

	private val bannerViewModel by lazy { BannerViewModel() }
	private var binding: FragmentHomeBinding? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		initData()
	}


	private fun initData() {
		bannerViewModel.fetchBanners()
		bannerViewModel.getBanners().observe(this){
			if(it?.isNotEmpty() == true) {
				val banner = (binding?.banner as Banner<BannerItem, ImageAdapter>)
				banner.apply {
					addBannerLifecycleObserver(requireActivity())
					setBannerRound(20f)
					indicator = RoundLinesIndicator(requireActivity())
					setAdapter(ImageAdapter(it))
				}
			}
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentHomeBinding.inflate(inflater, container, false)
		return binding!!.root
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}
}

