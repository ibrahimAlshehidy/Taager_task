package com.ibrahim.taager_task.main.ui

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.taager_task.databinding.ActivityProductsBinding
import com.ibrahim.taager_task.main.data.ProductsViewModel
import com.ibrahim.taager_task.main.data.ProductsViewModelFactory
import com.ibrahim.taager_task.network.ApiHelper
import com.ibrahim.taager_task.utils.RetrofitClient
import com.ibrahim.taager_task.utils.Status
import kotlinx.coroutines.flow.collect

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUi()
    }

    private fun initUi() {
        productsViewModel = ViewModelProvider(
            this,
            ProductsViewModelFactory(ApiHelper(RetrofitClient.apiInterface))
        ).get(ProductsViewModel::class.java)
        productsViewModel.getProducts()
        getProductsList()
        initRecycler()
    }

    private fun getProductsList() {
        lifecycleScope.launchWhenStarted {
            productsViewModel.mutableStateFlowProducts.collect {
                when (it.status) {
                    Status.LOADING -> {
                        binding.progressBarLoading.visibility = VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.progressBarLoading.visibility = GONE
                        productsAdapter.addAll(it.data?.body())
                        productsAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding.progressBarLoading.visibility = GONE
                        Toast.makeText(
                            this@ProductsActivity,
                            it.message,
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }
        }
    }

    private fun initRecycler() {
        productsAdapter = ProductsAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvProducts.layoutManager = linearLayoutManager
        binding.rvProducts.adapter = productsAdapter

    }
}