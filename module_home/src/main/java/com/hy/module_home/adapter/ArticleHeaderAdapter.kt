package com.hy.module_home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.hy.module_home.R
import com.hy.module_home.bean.BannerItem
import com.youth.banner.Banner
import com.youth.banner.indicator.RoundLinesIndicator

class ArticleHeaderAdapter(private val imageUrls: List<BannerItem>) : RecyclerView
.Adapter<ArticleHeaderAdapter.ViewHolder>() {
	private lateinit var mContext: Context

	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var banner: Banner<BannerItem, ImageAdapter> = itemView.findViewById(R.id.banners)
	}

	override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
		super.onAttachedToRecyclerView(recyclerView)
		mContext = recyclerView.context
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.banner, parent, false)
		return ViewHolder(view)
	}


	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.banner.apply {
			addBannerLifecycleObserver(mContext as LifecycleOwner)
			setBannerRound(20f)
			indicator = RoundLinesIndicator(mContext as Context)
			setAdapter(ImageAdapter(imageUrls))
		}
	}

	override fun getItemCount(): Int {
		return 1
	}
}