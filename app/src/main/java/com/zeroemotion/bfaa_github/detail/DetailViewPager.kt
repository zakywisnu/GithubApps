package com.zeroemotion.bfaa_github.detail

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.zeroemotion.bfaa_github.R
import com.zeroemotion.bfaa_github.followers.FollowersFragment
import com.zeroemotion.bfaa_github.following.FollowingFragment

class DetailViewPager(private val context: Context, fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    companion object {
        @StringRes
        private val TITLE_TAB = intArrayOf(R.string.followers, R.string.following)
    }

    private val pages = listOf(
        FollowersFragment(),
        FollowingFragment()
    )

    override fun getCount(): Int = pages.size

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(
        TITLE_TAB[position]
    )

}