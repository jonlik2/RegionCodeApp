package com.jonli.regioncodekotlinapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import com.jonli.regioncodekotlinapp.model.RegionCodeRepository

class CodeViewModel(application: Application, private val repository: RegionCodeRepository) : AndroidViewModel(application) {

    var code = ObservableField<String>()

    var region: ObservableField<String> = object : ObservableField<String>(code) {
        override fun get(): String? {
            val codeEdit: String
            val result: String

            if (code.get().toString().length == 1) {
                codeEdit = String.format("0%s", code.get().toString())
                result = repository.items[codeEdit].toString()
            } else {
                result = repository.items[code.get()].toString()
            }

            return if (result == "null") ""
            else result
        }
    }

}