package com.composedemo.network

import com.composedemo.data.ProductResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("products")
    suspend fun getProductList(): Response<ProductResponse>

}