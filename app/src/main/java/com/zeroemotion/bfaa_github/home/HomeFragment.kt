package com.zeroemotion.bfaa_github.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnPreDraw
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
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var dataBinding: FragmentHomeBinding
    private val homeAdapter = HomeAdapter()
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }

        rvSearchUser.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(context)
        }
        etSearchUser.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                val search = etSearchUser.text.toString().toLowerCase(Locale.getDefault())
                if (search.trim().isNotEmpty()){
                    viewModel.getUser(search)
                } else {
                    homeAdapter.clearData()
                }

            }

        })


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