package com.jonli.regioncodekotlinapp.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.jonli.regioncodekotlinapp.fragments.CodeFragment
import com.jonli.regioncodekotlinapp.fragments.RegionFragment

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    companion object {
        const val COUNT_FRAGMENT = 2
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> CodeFragment()
            1 -> RegionFragment()
            else -> null
        }
    }

    override fun getCount(): Int = COUNT_FRAGMENT

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Коды"
            1 -> "Регионы"
            else -> "Error"
        }
    }
}