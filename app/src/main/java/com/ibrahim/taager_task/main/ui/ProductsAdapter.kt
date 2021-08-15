package com.ibrahim.taager_task.main.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.taager_task.databinding.ItemProductsBinding
import com.ibrahim.taager_task.main.models.ProductsModelItem
import java.util.*

class ProductsAdapter(private var context: Context) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {


    private var dataList: ArrayList<ProductsModelItem>? = null
    private var layoutInflater: LayoutInflater? = null

    init {
        dataList = ArrayList()
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvIdNumber.text = dataList?.get(position)?.id
        holder.binding.tvCreatedAtNumber.text = dataList?.get(position)?.createdAt.toString()
        holder.binding.tvName.text = dataList?.get(position)?.name
        holder.binding.tvPriceNumber.text = dataList?.get(position)?.price.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("data", dataList?.get(position))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size!!
    }

    fun addAll(data: List<ProductsModelItem>?) {
        dataList?.clear()
        data?.let { dataList?.addAll(it) }
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemProductsBinding) : RecyclerView.ViewHolder(binding.root)


}