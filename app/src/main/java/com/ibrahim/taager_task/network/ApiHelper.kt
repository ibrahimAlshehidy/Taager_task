package com.ibrahim.taager_task.network

class ApiHelper(private val apiService: AppServices) {
    suspend fun getProducts() = apiService.getProducts()
}