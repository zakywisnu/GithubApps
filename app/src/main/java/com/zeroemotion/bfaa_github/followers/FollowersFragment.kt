package com.zeroemotion.bfaa_github.followers

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.databinding.FragmentFollowersBinding
import com.zeroemotion.bfaa_github.detail.DetailFollowAdapter
import com.zeroemotion.bfaa_github.detail.DetailFragment
import com.zeroemotion.bfaa_github.detail.DetailViewModel
import kotlinx.android.synthetic.main.fragment_followers.*
import kotlinx.android.synthetic.main.fragment_following.*
import org.koin.android.viewmodel.ext.android.viewModel

class FollowersFragment : Fragment() {

    private var username = ""
    private val viewModel : DetailViewModel by viewModel()
    private val followersAdapter = DetailFollowAdapter()
    private lateinit var dataBinding: FragmentFollowersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_followers, container, false)
        username = DetailFragment.username
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFollowers.apply {
            adapter = followersAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.getFollowers(username)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            followersLoading.visibility = if (it) View.VISIBLE else View.GONE
            if (it){
                followersError.visibility = View.GONE
                rvFollowers.visibility = View.GONE
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            followersError.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.dataUser.observe(viewLifecycleOwner, Observer {
            rvFollowers.visibility = View.VISIBLE
            followersAdapter.setData(it)
        })
    }

}