package com.jonli.regioncodekotlinapp.code

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jonli.regioncodekotlinapp.repository.Repository

class CodeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository.getInstance(application)

    var code = MutableLiveData<String>()

    private val _region = MutableLiveData<String>()
    val region: LiveData<String>
        get() = _region

    fun updateRegion(code: String) {
        val regionString = if (code.length == 1) {
            val codeString = "0$code"
            repository.items[codeString]
        } else {
            repository.items[code]
        }

        if (regionString == "null") _region.value = ""
        else _region.value = regionString
    }

}