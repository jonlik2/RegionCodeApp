package com.jonli.regioncodekotlinapp.region

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jonli.regioncodekotlinapp.repository.Repository

class RegionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository.getInstance(application)

    val set = repository.items.values.toMutableSet()
    val list = set.toMutableList()

    var region = MutableLiveData<String>()

    private val _code = MutableLiveData<String>()
    val code: LiveData<String>
        get() = _code

    fun updateCode(region: String) {
        val builder = StringBuilder()
        for (entry in repository.items) {
            if (entry.value == region) {
                builder.append(entry.key).append(", ")
            }
        }
        val result = builder.toString()

        _code.value = if (result.endsWith(", ")) result.substring(0, result.length - 2)
        else result
    }

}