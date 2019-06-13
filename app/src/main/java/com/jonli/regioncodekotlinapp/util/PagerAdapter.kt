package com.jonli.regioncodekotlinapp.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jonli.regioncodekotlinapp.code.CodeFragment
import com.jonli.regioncodekotlinapp.region.RegionFragment

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