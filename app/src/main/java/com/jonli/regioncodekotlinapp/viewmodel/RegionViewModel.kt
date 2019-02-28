package com.jonli.regioncodekotlinapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import com.jonli.regioncodekotlinapp.model.RegionCodeRepository

class RegionViewModel(application: Application, private val repository: RegionCodeRepository) : AndroidViewModel(application) {

    var region = ObservableField<String>()

    val set = repository.items.values.toMutableSet()
    val list = set.toMutableList()

    var code: ObservableField<String> = object : ObservableField<String>(region) {
        override fun get(): String? {
            val builder = StringBuilder()

            for (entry in repository.items) {
                if (entry.value == region.get()) {
                    builder.append(entry.key).append(", ")
                }
            }
            val result = builder.toString()

            return if (result.endsWith(", ")) result.substring(0, result.length - 2)
            else result
        }
    }

}