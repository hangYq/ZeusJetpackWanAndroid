package com.hy.module_home.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hy.module_home.adapter.ArticleAdapter
import com.hy.module_home.adapter.ArticleHeaderAdapter
import com.hy.module_home.databinding.FragmentHomeBinding
import com.hy.module_home.viewModel.BannerViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

	private val bannerViewModel by lazy { BannerViewModel() }
	private var _binding: FragmentHomeBinding? = null
	private val binding get() = _binding!!
	private var recyclerView: RecyclerView? = null
	private val config by lazy { ConcatAdapter.Config.Builder().setIsolateViewTypes(true).build() }
	private var concatAdapter :ConcatAdapter? =null
	private var adapterIndex = 0

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHomeBinding.inflate(inflater, container, false)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initAdapter()
		initData()
	}

	private fun initAdapter() {
		recyclerView = binding.rv
		recyclerView?.layoutManager = LinearLayoutManager(
			requireActivity(), RecyclerView.VERTICAL,
			false,
		)
		concatAdapter = ConcatAdapter(config)
	}

	private fun initData() {
		fetchBanners()
		fetchArticles()
	}

	private fun fetchBanners() {
		bannerViewModel.fetchBanners()
		bannerViewModel.getBanners().observe(requireActivity()) {
			if (it?.isNotEmpty() == true) {
				concatAdapter?.addAdapter(adapterIndex, ArticleHeaderAdapter(it))
				adapterIndex++
			}
		}
	}

	private fun fetchArticles() {
		val pagingAdapter = ArticleAdapter()
		concatAdapter?.addAdapter(adapterIndex, pagingAdapter)
		recyclerView?.adapter = concatAdapter
		lifecycleScope.launch {
			bannerViewModel.fetchArticles().collect {
				pagingAdapter.submitData(it)
			}
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}

