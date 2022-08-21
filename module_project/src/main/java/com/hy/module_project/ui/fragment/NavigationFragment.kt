package com.hy.module_project.ui.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.hy.commom.base.BaseFragment
import com.hy.commom.config.ArouterConfig
import com.hy.module_project.adapter.NavigationAdapter
import com.hy.module_project.bean.NavigationData
import com.hy.module_project.databinding.FragmentNavigationBinding
import com.hy.module_project.viewModel.NavigationViewModel

class NavigationFragment : BaseFragment<FragmentNavigationBinding, NavigationViewModel>
	(FragmentNavigationBinding::inflate) {

	private lateinit var mRecycleView: RecyclerView
	override val mViewModel by lazy { NavigationViewModel() }

	override fun initData() {
		mViewModel.fetchNavigation()
		mViewModel.navigationList.observe(this) {
			if (it?.isNotEmpty() == true) {
				initView(it)
			}
			// TODO： 空白页面处理
		}
	}

	private fun initView(list: List<NavigationData>) {
		mRecycleView = mBinding.rv
		mRecycleView.layoutManager =
			LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
		val adapter = NavigationAdapter(list)
		adapter.setOnItemClickListener(object : NavigationAdapter.OnItemClickerListener {
			override fun onItemClick(article: NavigationData.Article?) {
				ARouter.getInstance()
					.build(ArouterConfig.COMMON_WEBVIEW)
					.withString("path", article?.link)
					.navigation()
			}
		})
		mRecycleView.adapter = adapter
	}
}