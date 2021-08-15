package com.ibrahim.taager_task.main.data

import com.ibrahim.taager_task.network.ApiHelper

class ProductsRepository(private val apiHelper: ApiHelper) {
    suspend fun getProducts() = apiHelper.getProducts()
}