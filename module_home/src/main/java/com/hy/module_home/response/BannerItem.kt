package com.hy.module_home.response

import com.squareup.moshi.Json

data class BannerItem(
    @Json(name = "desc") var desc: String?,
    @Json(name = "id") var id: Int?,
    @Json(name = "imagePath") var imagePath: String?,
    @Json(name = "isVisible") var isVisible: Int?,
    @Json(name = "order") var order: Int?,
    @Json(name = "title") var title: String?,
    @Json(name = "type") var type: Int?,
    @Json(name = "url") var url: String?,
)
