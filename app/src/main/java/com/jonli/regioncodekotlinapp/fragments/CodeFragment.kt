package com.jonli.regioncodekotlinapp.fragments


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jonli.regioncodekotlinapp.viewmodel.CodeViewModel
import com.jonli.regioncodekotlinapp.MainActivity
import com.jonli.regioncodekotlinapp.R
import com.jonli.regioncodekotlinapp.databinding.FragmentCodeBinding
import kotlinx.android.synthetic.main.fragment_code.*


/**
 * A simple [Fragment] subclass.
 *
 */
class CodeFragment : Fragment() {

    private lateinit var model: CodeViewModel

    private lateinit var binding: FragmentCodeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_code, container, false)
        val view: View = binding.root

        model = (activity as MainActivity).createCodeViewModel()
        binding.viewModel = model

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_text_code.setOnClickListener { edit_text_code.setText("") }
    }
}
