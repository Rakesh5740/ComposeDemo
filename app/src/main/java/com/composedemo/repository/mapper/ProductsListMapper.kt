package com.composedemo.repository.mapper

import com.composedemo.data.ProductData
import com.composedemo.data.ProductList
import com.composedemo.data.ProductResponse
import com.composedemo.data.Products
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ProductsListMapper {

    suspend fun mapData(
        productResponse: ProductResponse,
        dispatcher: CoroutineDispatcher = Dispatchers.Default
    ): ProductList =
        withContext(dispatcher) {
            val data = productResponse.products?.map { data ->
                object : ProductData {
                    override val id: Int
                        get() = data.id ?: 0
                    override val images: String
                        get() = data.thumbnail ?: "djfdfh"
                    override val title: String
                        get() = data.title ?: "Helloo"
                }
            }
            object : ProductList {
                override val productList: List<ProductData>
                    get() = data ?: emptyList()
            }
        }
}