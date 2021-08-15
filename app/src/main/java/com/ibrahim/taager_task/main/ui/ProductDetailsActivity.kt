package com.ibrahim.taager_task.main.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ibrahim.taager_task.databinding.ActivityProductDetailsBinding
import com.ibrahim.taager_task.main.models.ProductsModelItem

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        initUI()
        initEventDriven()
    }

    private fun initUI() {
        val item = intent.getParcelableExtra<ProductsModelItem>("data")
        binding.tvIdNumber.text = item?.id
        binding.tvCreatedAtNumber.text = item?.createdAt.toString()
        binding.tvName.text = item?.name
        binding.tvPriceNumber.text = item?.price.toString()
    }

    private fun initEventDriven() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

}
