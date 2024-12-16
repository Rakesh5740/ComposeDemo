package com.composedemo.data

import com.composedemo.Constant
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = Constant.Products.PRODUCTS)
    var products: List<Products>? = null,
)

@JsonClass(generateAdapter = true)
data class Products(
    @Json(name = Constant.Products.PRODUCTS)
    var id: Int? = null,
    @Json(name = Constant.Products.TITLE)
    var title: String? = null,
    @Json(name = Constant.Products.DESCRIPTION)
    var description: String? = null,
    @Json(name = Constant.Products.THUMBNAIL)
    var thumbnail: String? = null,
)

