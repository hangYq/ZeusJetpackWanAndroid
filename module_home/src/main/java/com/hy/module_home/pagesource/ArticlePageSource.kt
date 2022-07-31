package com.hy.module_home.pagesource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hy.module_home.bean.Articles
import com.hy.module_home.api.HomeApi

class ArticlePageSource(private val homeRepository: HomeApi) : PagingSource<Int, Articles
.Article>() {
	override fun getRefreshKey(state: PagingState<Int, Articles.Article>): Int? {
		return null
	}

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Articles.Article> {
		return try {
			val page = params.key ?: 0
			val pageSize = params.loadSize
			val response = homeRepository.fetchArticles(page)
			val articles = response.data?.datas
			val preKey = if (page > 1) page - 1 else null
			val nexKey = if (articles?.isNotEmpty() == true) page + 1 else null
			LoadResult.Page(articles!!, preKey, nexKey)
		} catch (e: Exception) {
			LoadResult.Error(e)
		}
	}
}