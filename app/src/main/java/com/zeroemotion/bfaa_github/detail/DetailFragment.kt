package com.zeroemotion.bfaa_github.detail

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.core.domain.model.User
import com.zeroemotion.bfaa_github.core.utils.themeColor
import com.zeroemotion.bfaa_github.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    companion object{
        var username = ""
    }

    private val viewModel : DetailViewModel by viewModel()
    private lateinit var dataBinding: FragmentDetailBinding
    private val args : DetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.fragment
            duration = 500.toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(R.attr.colorSurface))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        username = args.username
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = username
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = context?.let { DetailViewPager(it,childFragmentManager) }
        detailViewPager.adapter = pagerAdapter
        tabs.setupWithViewPager(detailViewPager)
        viewModel.getDetail(username)

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            detailLoading.visibility = if (it) View.VISIBLE else View.GONE
            if (it) detailError.visibility = View.GONE
        })
        viewModel.error.observe(viewLifecycleOwner, Observer {
            detailError.visibility = if (it) View.VISIBLE else View.GONE
        })
        viewModel.dataDetail.observe(viewLifecycleOwner, Observer {
            applyToLayout(it)
        })
    }

    private fun applyToLayout(user: User){
        dataBinding.user = user
    }

}