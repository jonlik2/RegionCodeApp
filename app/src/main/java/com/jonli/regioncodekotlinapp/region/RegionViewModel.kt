package com.jonli.regioncodekotlinapp.region

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.databinding.ObservableField
import com.jonli.regioncodekotlinapp.repository.Repository

class RegionViewModel(application: Application, private val repository: Repository) : AndroidViewModel(application) {

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