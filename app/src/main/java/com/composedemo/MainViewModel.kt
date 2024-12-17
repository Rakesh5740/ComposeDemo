package com.composedemo

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composedemo.data.ProductList
import com.composedemo.model.CardData
import com.composedemo.network.ApiState
import com.composedemo.repository.ProductsRepository
import com.composedemo.screens.HomeScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val _productsList = MutableLiveData<ProductList>()
    val productsList: LiveData<ProductList>
        get() = _productsList

    private val _selectedCard = MutableLiveData<CardData>()
    val selectedCard: LiveData<CardData>
        get() = _selectedCard

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            when (val productList = productsRepository.getProductsList()) {
                is ApiState.Loading -> {
                    // Show loading indicator
                }

                is ApiState.Success -> {
                    // Display data
                    val data = productList.data
                    _productsList.value = data
                }

                is ApiState.Error -> {
                }
            }
        }
    }

    internal fun updateSelectedCard(cardData: CardData) {
        _selectedCard.value = cardData
    }
}