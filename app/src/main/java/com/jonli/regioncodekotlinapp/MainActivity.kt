package com.jonli.regioncodekotlinapp

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.jonli.regioncodekotlinapp.util.PagerAdapter
import com.jonli.regioncodekotlinapp.util.obtainViewModel
import com.jonli.regioncodekotlinapp.viewmodel.CodeViewModel
import com.jonli.regioncodekotlinapp.viewmodel.RegionViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var codeViewModel: CodeViewModel
    private lateinit var regionViewModel: RegionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = PagerAdapter(supportFragmentManager)

        tab_layout.setupWithViewPager(viewPager)

        codeViewModel = createCodeViewModel()
        regionViewModel = createRegionViewModel()
    }

    fun createCodeViewModel(): CodeViewModel = obtainViewModel(CodeViewModel::class.java)

    fun createRegionViewModel(): RegionViewModel = obtainViewModel(RegionViewModel::class.java)

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
