package com.hy.module_project.ui.fragment

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hy.commom.base.BaseFragment
import com.hy.module_project.adapter.SystemAdapter
import com.hy.module_project.bean.SystemDataItem
import com.hy.module_project.databinding.FragmentSystemBinding
import com.hy.module_project.viewModel.SystemViewModel


class SystemFragment : BaseFragment<FragmentSystemBinding, SystemViewModel>
	(FragmentSystemBinding::inflate) {

	override val mViewModel by lazy { SystemViewModel() }
	private var mRecycleView : RecyclerView? =null

	override fun initData() {
		mViewModel.fetchSystems()
		mViewModel.systems.observe(this) {
			if (it?.isNotEmpty() == true) {
				initView(it)
			}
			// TODO： 空白页面处理
		}
	}

	private fun initView(list: List<SystemDataItem>) {
		mRecycleView = mBinding.rv
		mRecycleView?.layoutManager = LinearLayoutManager(
			requireActivity(), RecyclerView.VERTICAL,
			false,
		)
		val adapter = SystemAdapter(list)
		// 第五步：调用自定义的 setOnItemClickListener，并实现自己的回调逻辑
		adapter.setOnItemClickListener(object : SystemAdapter.OnItemClickListener{
			override fun onItemClick(item: SystemDataItem.Children?) {
				Log.d("dddddd","$item")
			}
		})
		mRecycleView!!.adapter = adapter
	}
}