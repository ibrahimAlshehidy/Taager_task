package com.ibrahim.taager_task.main.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.taager_task.utils.Resource
import com.ibrahim.taager_task.main.models.ProductsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class ProductsViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    private val _mutableStateFlowProducts: MutableStateFlow<Resource<Response<ProductsModel>>> =
        MutableStateFlow(
            Resource.loading(null)
        )
    val mutableStateFlowProducts: MutableStateFlow<Resource<Response<ProductsModel>>> =
        _mutableStateFlowProducts

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO)
        {
            mutableStateFlowProducts.emit(Resource.loading(data = null))
            try {
                mutableStateFlowProducts.emit(
                    Resource.success(
                        data = productsRepository.getProducts()
                    )
                )
            } catch (exception: Exception) {
                mutableStateFlowProducts.emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Sorry, something went wrong.!"
                    )
                )
            }
        }
    }

}