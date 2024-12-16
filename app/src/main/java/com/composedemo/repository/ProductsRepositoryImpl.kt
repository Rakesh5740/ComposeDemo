package com.composedemo.repository

import com.composedemo.network.ApiService
import com.composedemo.data.ProductList
import com.composedemo.network.ApiException
import com.composedemo.network.ApiState
import com.composedemo.network.suspendedNetworkGetRequest
import com.composedemo.repository.mapper.ProductsListMapper
import kotlinx.coroutines.Dispatchers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductsRepository {

    override suspend fun getProductsList(): ApiState<ProductList> {
        return suspendedNetworkGetRequest(
            fetch = {
                apiService.getProductList()
            },
            map = { response ->
                ProductsListMapper.mapData(response)
            },
            onSuccess = {
            },
            onMappingFailure = { mappingFailure -> Timber.e(mappingFailure) },
            onApiFailure = { apiFailure -> Timber.e(ApiException(apiFailure)) },
            dispatcher = Dispatchers.IO
        )
    }
}