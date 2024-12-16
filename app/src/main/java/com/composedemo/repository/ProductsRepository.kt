package com.composedemo.repository

import com.composedemo.data.ProductList
import com.composedemo.network.ApiState
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getProductsList(): ApiState<ProductList>

}