package com.hy.module_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.hy.module_project.R
import com.hy.module_project.bean.SystemDataItem


class SystemAdapter(private val list: List<SystemDataItem>) : Adapter<SystemAdapter.ViewHolder>() {

	// 第二步：声明一个延迟初始化变量
	private lateinit var onItemClickListener: OnItemClickListener

	// 第一步：定义一个接口
	interface OnItemClickListener {
		fun onItemClick(item: SystemDataItem.Children?)
	}

	// 第三步：设置一个函数用于设置接口
	fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
		this.onItemClickListener = onItemClickListener
	}

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val flowTitle: TextView = view.findViewById(R.id.flow_title)
		val chipGroup: ChipGroup = view.findViewById(R.id.chip_group)
		val context: Context = view.context
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.flow_items, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.flowTitle.text = list[position].name
		if (list[position].children?.isNotEmpty() == true) {
			for (child in list[position].children!!) {
				val chip = Chip(holder.context)
				chip.text = child?.name ?: ""
				chip.textSize = 12f
				chip.width = ViewGroup.LayoutParams.WRAP_CONTENT
				chip.height = ViewGroup.LayoutParams.WRAP_CONTENT
				// 第四步：实现接口回调
				onItemClickListener.let {
					chip.apply {
						setOnClickListener{
							onItemClickListener.onItemClick(child)
						}
					}
				}
				holder.chipGroup.addView(chip)
			}
		}
	}

	override fun getItemCount(): Int {
		return list.size
	}
}