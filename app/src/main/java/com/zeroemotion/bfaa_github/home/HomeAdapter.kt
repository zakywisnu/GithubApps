package com.zeroemotion.bfaa_github.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.core.databinding.ItemUserBinding
import com.zeroemotion.bfaa_github.core.domain.model.User

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    private var listData = ArrayList<User>()

    fun setData(newList: List<User>){
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = DataBindingUtil.inflate<ItemUserBinding>(inflater, R.layout.item_user, parent,false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view.user = listData[position]
    }

    override fun getItemCount(): Int = listData.size

    class HomeViewHolder(var view: ItemUserBinding): RecyclerView.ViewHolder(view.root)

}