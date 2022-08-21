package com.hy.module_home.ui.fragment

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hy.commom.base.BaseFragment
import com.hy.module_home.adapter.ArticleAdapter
import com.hy.module_home.adapter.ArticleHeaderAdapter
import com.hy.module_home.databinding.FragmentHomeBinding
import com.hy.module_home.viewModel.HomeViewModel
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(FragmentHomeBinding::inflate) {

	override  val mViewModel by lazy { HomeViewModel() }

	private var recyclerView: RecyclerView? = null
	private val config by lazy { ConcatAdapter.Config.Builder().setIsolateViewTypes(true).build() }
	private var concatAdapter :ConcatAdapter? =null
	private var adapterIndex = 0

	private fun initAdapter() {
		recyclerView = mBinding.rv
		recyclerView?.layoutManager = LinearLayoutManager(
			requireActivity(), RecyclerView.VERTICAL,
			false,
		)
		concatAdapter = ConcatAdapter(config)
	}

	override fun initData() {
		initAdapter()
		mBinding.includeAppBar.tvAppBarTitle.text = "主页"
		fetchBanners()
		fetchArticles()
	}

	private fun fetchBanners() {
		mViewModel.fetchBanners()
		mViewModel.getBanners().observe(requireActivity()) {
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
			// bannerViewModel.fetchArticles().collect 是 Flow 订阅数据的体现，类似于LiveData 的 onserver
			mViewModel.fetchArticles().collect {
				pagingAdapter.submitData(it)
			}
		}
	}
}

