package com.zeroemotion.bfaa_github.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var dataBinding: FragmentHomeBinding
    private val homeAdapter = HomeAdapter()
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSearchUser.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(context)
        }


        observeSearchUser()
    }

    private fun observeSearchUser() {
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            searchLoading.visibility = if (it) View.VISIBLE else View.GONE
            if (it) {
                searchError.visibility = View.GONE
                rvSearchUser.visibility = View.GONE
            }
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            searchError.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.dataUser.observe(viewLifecycleOwner, Observer {
            rvSearchUser.visibility = View.VISIBLE
            homeAdapter.setData(it)
        })
    }

}