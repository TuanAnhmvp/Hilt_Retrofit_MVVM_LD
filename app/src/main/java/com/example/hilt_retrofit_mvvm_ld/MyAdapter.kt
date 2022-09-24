package com.example.hilt_retrofit_mvvm_ld

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilt_retrofit_mvvm_ld.databinding.RecyclerRowBinding
import com.example.hilt_retrofit_mvvm_ld.network.RecyclerData

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //Viewbinding
    private lateinit var binding: RecyclerRowBinding

    private var listData: List<RecyclerData>? = null

    fun setListData(listData: List<RecyclerData>?){
        this.listData = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData ==null)return 0
        return listData?.size!!
    }

    inner class MyViewHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){
        val thumbImage = binding.thumbImage
        val tvName = binding.tvName
        val tvDesc = binding.tvDesc

        fun bind(data: RecyclerData) {
            tvName.text = data.name
            tvDesc.text = data.description

            Glide.with(thumbImage)
                .load(data.owner?.avatar_url)
                .into(thumbImage)
        }
    }
}