package com.composedemo.data


interface ProductList {
    val productList: List<ProductData?>
}

interface ProductData {
    val id: Int
    val title: String
    val images: String
}