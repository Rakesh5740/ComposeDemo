package com.composedemo.repository

import com.composedemo.ApiService
import com.composedemo.data.ProductList
import com.composedemo.network.ApiState
import com.composedemo.network.networkBoundRequest
import com.composedemo.repository.mapper.ProductsListMapper
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductsRepository {

    override fun getProductsList(): Flow<ApiState<ProductList>> {
        return networkBoundRequest(
            createRequest = { /*No Specific request needed*/ },
            request = {
                apiService.getProductList()
            },
            onSuccess = {
                ProductsListMapper.mapData(it)
            },
            onMappingFailure = { mappingFailure -> Timber.e(mappingFailure) },
            onApiFailure = { apiFailure -> Timber.w(apiFailure) }
        )
    }
}