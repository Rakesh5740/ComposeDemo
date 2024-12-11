package com.composedemo

import com.composedemo.data.ProductResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("posts")
    suspend fun getProductList(): Response<ProductResponse>

}