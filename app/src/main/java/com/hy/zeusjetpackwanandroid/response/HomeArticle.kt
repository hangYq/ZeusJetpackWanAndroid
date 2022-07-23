package com.hy.zeusjetpackwanandroid.response

import com.squareup.moshi.Json


data class HomeArticle(
    @Json(name = "datas") var datas: MutableList<ArticleEntity>,
    @Json(name = "curPage") var curPage: Int
) {
    data class ArticleEntity(
        @Json(name = "apkLink") var apkLink: String,
        @Json(name = "audit") var audit: Int?,
        @Json(name = "author") var author: String?,
        @Json(name = "canEdit") var canEdit: Boolean?,
        @Json(name = "chapterName") var chapterName: String?,
        @Json(name = "chapterId") var chapterId: Int?,
        @Json(name = "collect") var collect: Boolean?,
        @Json(name = "courseId") var courseId: Int?,
        @Json(name = "desc") var desc: String,
    )
}