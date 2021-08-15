package com.ibrahim.taager_task.main.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsModelItem(
    val createdAt: Int,
    val id: String,
    val name: String,
    val price: Int
) : Parcelable
