package com.jonli.regioncodekotlinapp

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.jonli.regioncodekotlinapp.util.PagerAdapter
import com.jonli.regioncodekotlinapp.util.obtainViewModel
import com.jonli.regioncodekotlinapp.code.CodeViewModel
import com.jonli.regioncodekotlinapp.region.RegionViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
