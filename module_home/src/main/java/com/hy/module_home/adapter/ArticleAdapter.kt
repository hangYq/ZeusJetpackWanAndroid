package com.hy.module_home.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.hy.commom.config.ArouterConfig
import com.hy.module_home.R
import com.hy.module_home.bean.Articles

class ArticleAdapter : PagingDataAdapter<Articles.Article, ArticleAdapter.ViewHolder>(COMPARATOR) {
	companion object {
		private val COMPARATOR = object : DiffUtil.ItemCallback<Articles.Article>() {
			override fun areItemsTheSame(oldItem: Articles.Article, newItem: Articles.Article): Boolean {
				return oldItem.id == newItem.id
			}

			override fun areContentsTheSame(
				oldItem: Articles.Article,
				newItem: Articles.Article
			): Boolean {
				return oldItem == newItem
			}
		}
	}

	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
		val tvTime: TextView = itemView.findViewById(R.id.tv_time)
		val tvChapter: TextView = itemView.findViewById(R.id.tv_chapter)
		val superChapter: TextView = itemView.findViewById(R.id.tv_super_chapter)
		val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
	}


	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
		return ViewHolder(view)
	}


	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val bean = getItem(position)
		holder.let {
			it.tvAuthor.text = if(!TextUtils.isEmpty(bean?.author)) bean?.author else bean?.shareUser?:""
			it.tvTime.text = bean?.niceShareDate?.toString() ?: ""
			it.tvTitle.text = bean?.title ?: ""
			it.superChapter.text = bean?.superChapterName ?: ""
			it.tvChapter.text = bean?.chapterName ?: ""
		}

		holder.itemView.setOnClickListener {
			ARouter.getInstance()
				.build(ArouterConfig.COMMON_WEBVIEW)
				.withString("path", bean?.link)
				.navigation()
		}
	}
}