package com.jonli.regioncodekotlinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.jonli.regioncodekotlinapp.util.PagerAdapter
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pagerAdapter = PagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = pagerAdapter

        val tabLayout = view.tab_layout
        tabLayout.setupWithViewPager(viewPager)
    }
}