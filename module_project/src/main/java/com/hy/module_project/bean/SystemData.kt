package com.hy.module_project.bean

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@Keep
@JsonClass(generateAdapter = true)
data class SystemDataItem(
	@Json(name = "author")
	val author: String?,
	@Json(name = "children")
	val children: List<Children?>?,
	@Json(name = "courseId")
	val courseId: Int?,
	@Json(name = "cover")
	val cover: String?,
	@Json(name = "desc")
	val desc: String?,
	@Json(name = "id")
	val id: Int?,
	@Json(name = "lisense")
	val lisense: String?,
	@Json(name = "lisenseLink")
	val lisenseLink: String?,
	@Json(name = "name")
	val name: String?,
	@Json(name = "order")
	val order: Int?,
	@Json(name = "parentChapterId")
	val parentChapterId: Int?,
	@Json(name = "userControlSetTop")
	val userControlSetTop: Boolean?,
	@Json(name = "visible")
	val visible: Int?
) {
	@Keep
	@JsonClass(generateAdapter = true)
	data class Children(
		@Json(name = "author")
		val author: String?,
		@Json(name = "children")
		val children: List<Any?>?,
		@Json(name = "courseId")
		val courseId: Int?,
		@Json(name = "cover")
		val cover: String?,
		@Json(name = "desc")
		val desc: String?,
		@Json(name = "id")
		val id: Int?,
		@Json(name = "lisense")
		val lisense: String?,
		@Json(name = "lisenseLink")
		val lisenseLink: String?,
		@Json(name = "name")
		val name: String?,
		@Json(name = "order")
		val order: Int?,
		@Json(name = "parentChapterId")
		val parentChapterId: Int?,
		@Json(name = "userControlSetTop")
		val userControlSetTop: Boolean?,
		@Json(name = "visible")
		val visible: Int?
	)
}