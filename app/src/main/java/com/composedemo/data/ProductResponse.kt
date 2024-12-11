package com.composedemo.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "userId")
    var userId: Int? = null,
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "body")
    var body: String? = null
)

@JsonClass(generateAdapter = true)
data class Products(
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "description")
    var description: String? = null,
    @Json(name = "category")
    var category: String? = null,
    @Json(name = "price")
    var price: Double? = null,
    @Json(name = "discountPercentage")
    var discountPercentage: Double? = null,
    @Json(name = "rating")
    var rating: Double? = null,
    @Json(name = "stock")
    var stock: Int? = null,
    @Json(name = "tags")
    var tags: ArrayList<String> = arrayListOf(),
    @Json(name = "brand")
    var brand: String? = null,
    @Json(name = "sku")
    var sku: String? = null,
    @Json(name = "weight")
    var weight: Int? = null,
    @Json(name = "dimensions")
    var dimensions: Dimensions? = Dimensions(),
    @Json(name = "warrantyInformation")
    var warrantyInformation: String? = null,
    @Json(name = "shippingInformation")
    var shippingInformation: String? = null,
    @Json(name = "availabilityStatus")
    var availabilityStatus: String? = null,
    @Json(name = "reviews")
    var reviews: ArrayList<Reviews> = arrayListOf(),
    @Json(name = "returnPolicy")
    var returnPolicy: String? = null,
    @Json(name = "minimumOrderQuantity")
    var minimumOrderQuantity: Int? = null,
    @Json(name = "meta")
    var meta: Meta? = Meta(),
    @Json(name = "images")
    var images: ArrayList<String> = arrayListOf(),
    @Json(name = "thumbnail")
    var thumbnail: String? = null
)

@JsonClass(generateAdapter = true)
data class Dimensions(
    @Json(name = "width")
    var width: Double? = null,
    @Json(name = "height")
    var height: Double? = null,
    @Json(name = "depth")
    var depth: Double? = null
)

@JsonClass(generateAdapter = true)
data class Reviews(
    @Json(name = "rating")
    var rating: Int? = null,
    @Json(name = "comment")
    var comment: String? = null,
    @Json(name = "date")
    var date: String? = null,
    @Json(name = "reviewerName")
    var reviewerName: String? = null,
    @Json(name = "reviewerEmail")
    var reviewerEmail: String? = null
)

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "createdAt")
    var createdAt: String? = null,
    @Json(name = "updatedAt")
    var updatedAt: String? = null,
    @Json(name = "barcode")
    var barcode: String? = null,
    @Json(name = "qrCode")
    var qrCode: String? = null
)

