package com.ibrahim.taager_task.network

import com.ibrahim.taager_task.main.models.ProductsModel
import retrofit2.Response
import retrofit2.http.GET


interface AppServices {
    @GET("products")
    suspend fun getProducts(
    ): Response<ProductsModel>
}