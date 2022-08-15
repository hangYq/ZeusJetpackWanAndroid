package com.hy.commom.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(val bindingBlock: (LayoutInflater, ViewGroup?, Boolean) -> VB) :
	Fragment() {
	private var _binding: VB? = null
	protected val binding get() = _binding!!

	lateinit var mContext: Context
	abstract val mViewModel: VM

	abstract fun initData()

	override fun onAttach(context: Context) {
		super.onAttach(context)
		mContext = context
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = bindingBlock(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		initData()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}