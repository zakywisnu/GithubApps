package com.zeroemotion.bfaa_github.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.core.databinding.ItemFollowBinding
import com.zeroemotion.bfaa_github.core.domain.model.User

class DetailFollowAdapter : RecyclerView.Adapter<DetailFollowAdapter.DetailFollowViewHolder>(){

    private var listData = ArrayList<User>()

    fun setData(newList: List<User>?){
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailFollowAdapter.DetailFollowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemFollowBinding>(inflater, R.layout.item_follow,parent,false)
        return DetailFollowViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DetailFollowAdapter.DetailFollowViewHolder,
        position: Int
    ) {
        holder.view.user = listData[position]
    }

    override fun getItemCount(): Int = listData.size

    class DetailFollowViewHolder(var view: ItemFollowBinding): RecyclerView.ViewHolder(view.root) {

    }


}