package com.example.depedencyinjection.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.depedencyinjection.databinding.ItemMakeupBinding
import com.example.depedencyinjection.model.ResponseDataMakeup
import com.example.depedencyinjection.model.ResponseDataMakeupItem

class MakeupAdapter(var listmakeup : List<ResponseDataMakeupItem>): RecyclerView.Adapter<MakeupAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemMakeupBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakeupAdapter.ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MakeupAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.name.text = listmakeup!![position].name
        holder.binding.category.text = listmakeup!![position].category
        holder.binding.price.text = listmakeup!![position].price
        Glide.with(holder.itemView.context).load(listmakeup!![position].imageLink).into(holder.binding.img)

    }

    override fun getItemCount(): Int {

        return listmakeup.size

    }
}