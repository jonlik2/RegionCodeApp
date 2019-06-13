package com.jonli.regioncodekotlinapp.code

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jonli.regioncodekotlinapp.repository.Repository

class CodeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository.getInstance(application)

    private val _code = MutableLiveData<String>()
    val code: LiveData<String>
        get() = _code

    private val _region = MutableLiveData<String>()
    val region: LiveData<String>
        get() = _region

    init {
        val regionString = if (_code.value?.length == 1) {
            val codeString = "0${_code.value}"
            repository.items[codeString]
        } else {
            repository.items[_code.value]
        }

        if (regionString == "null") _region.value = ""
        else _region.value = regionString
    }

    /*var region: ObservableField<String> = object : ObservableField<String>(_code) {
        override fun get(): String? {
            val codeEdit: String
            val result: String

            if (_code.get().toString().length == 1) {
                codeEdit = String.format("0%s", _code.get().toString())
                result = repository.items[codeEdit].toString()
            } else {
                result = repository.items[_code.get()].toString()
            }

            return if (result == "null") ""
            else result
        }
    }*/

}