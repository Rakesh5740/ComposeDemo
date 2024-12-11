package com.composedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composedemo.data.ProductList
import com.composedemo.network.ApiState
import com.composedemo.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val _productsList = MutableLiveData<ApiState<ProductList>>()
    val productsList: LiveData<ApiState<ProductList>>
        get() = _productsList

    init {
        fetchProducts()
    }

    internal fun fetchProducts() {
        viewModelScope.launch {
            productsRepository.getProductsList().collect {
                _productsList.postValue(it)
            }
        }
    }
}