package com.ibrahim.taager_task.main.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.taager_task.network.ApiHelper

@Suppress("UNCHECKED_CAST")

class ProductsViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(ProductsRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}