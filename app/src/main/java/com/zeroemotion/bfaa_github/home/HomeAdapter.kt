package com.zeroemotion.bfaa_github.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.core.databinding.ItemUserBinding
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.utils.CustomOnClick

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(), CustomOnClick {

    private var listData = ArrayList<User>()

    fun setData(newList: List<User>?) {
        if (newList == null) return
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    fun clearData() {
        listData.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<ItemUserBinding>(inflater, R.layout.item_user, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view.user = listData[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int = listData.size

    class HomeViewHolder(var view: ItemUserBinding) : RecyclerView.ViewHolder(view.root) {
    }

    override fun onClicked(view: View) {
        val user = view.tag.toString()
        val userCardDetailTransitionName =
            view.context.getString(R.string.user_detail_transition_name)
        val extras = FragmentNavigatorExtras(view to userCardDetailTransitionName)
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
            user
        )
        Navigation.findNavController(view).navigate(action,extras)
    }

}