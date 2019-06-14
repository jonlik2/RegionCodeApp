package com.jonli.regioncodekotlinapp.code


import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jonli.regioncodekotlinapp.R
import com.jonli.regioncodekotlinapp.databinding.FragmentCodeBinding
import kotlinx.android.synthetic.main.fragment_code.*

class CodeFragment : Fragment() {

    private lateinit var codeViewModel: CodeViewModel
    private lateinit var viewModelFactory: CodeViewModelFactory

    private lateinit var binding: FragmentCodeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_code, container, false)

        viewModelFactory = CodeViewModelFactory(activity!!.application)
        codeViewModel = ViewModelProviders.of(this, viewModelFactory).get(CodeViewModel::class.java)

        binding.viewModel = codeViewModel
        binding.lifecycleOwner = this

        codeViewModel.code.observe(this, Observer {code ->
            code?.let {
                codeViewModel.updateRegion(it)
            }
        })

        Log.d("TTT", "fragment create view")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_text_code.setOnClickListener { edit_text_code.setText("") }
    }
}
