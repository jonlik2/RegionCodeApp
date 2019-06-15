package com.jonli.regioncodekotlinapp.region

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RegionViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegionViewModel::class.java)) {
            return RegionViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}