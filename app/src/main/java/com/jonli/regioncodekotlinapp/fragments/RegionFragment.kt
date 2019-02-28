package com.jonli.regioncodekotlinapp.fragments


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.jonli.regioncodekotlinapp.MainActivity
import com.jonli.regioncodekotlinapp.R
import com.jonli.regioncodekotlinapp.databinding.FragmentRegionBinding
import com.jonli.regioncodekotlinapp.viewmodel.RegionViewModel
import kotlinx.android.synthetic.main.fragment_region.*
import kotlinx.android.synthetic.main.fragment_region.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class RegionFragment : Fragment() {

    private lateinit var model: RegionViewModel

    private lateinit var binding: FragmentRegionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_region, container, false)
        val view: View = binding.root

        model = (activity as MainActivity).createRegionViewModel()
        binding.viewModel = model

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter<String>(activity, android.R.layout.simple_dropdown_item_1line, model.list)
        auto_text_region.setAdapter(adapter)

        auto_text_region.setOnClickListener { auto_text_region.setText("") }
    }

}
