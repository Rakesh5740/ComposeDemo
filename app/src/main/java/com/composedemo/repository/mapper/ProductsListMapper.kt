package com.composedemo.repository.mapper

import com.composedemo.data.ProductList
import com.composedemo.data.ProductResponse

object ProductsListMapper {

    fun mapData(productResponse: ProductResponse) =
        productResponse.let {
            ProductList(
                it.userId ?: 0,
                it.id ?: 0,
                it.title ?: "Hello",
                it.body ?: "adhgsjfhgdhfgfhdfg"
            )
        }

}