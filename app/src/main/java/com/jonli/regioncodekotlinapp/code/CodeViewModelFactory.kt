package com.jonli.regioncodekotlinapp.code

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CodeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CodeViewModel::class.java)) {
            return CodeViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}