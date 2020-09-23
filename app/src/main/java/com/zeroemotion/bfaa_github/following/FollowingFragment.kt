package com.zeroemotion.bfaa_github.following

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.detail.DetailFollowAdapter
import com.zeroemotion.bfaa_github.detail.DetailFragment
import com.zeroemotion.bfaa_github.detail.DetailViewModel
import kotlinx.android.synthetic.main.fragment_followers.*
import kotlinx.android.synthetic.main.fragment_following.*
import org.koin.android.viewmodel.ext.android.viewModel

class FollowingFragment : Fragment() {

    private var username = ""
    private val viewModel: DetailViewModel by viewModel()
    private val followingAdapter = DetailFollowAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        username = DetailFragment.username
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFollowing.apply {
            adapter = followingAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.getFollowing(username)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            followingLoading.visibility = if (it) View.VISIBLE else View.GONE
            if (it){
                followingError.visibility = View.GONE
                rvFollowing.visibility = View.GONE
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            followingError.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.dataUser.observe(viewLifecycleOwner, Observer {
            rvFollowing.visibility = View.VISIBLE
            followingAdapter.setData(it)
        })
    }
}