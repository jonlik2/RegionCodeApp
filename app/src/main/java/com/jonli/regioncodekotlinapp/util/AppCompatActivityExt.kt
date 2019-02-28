package com.jonli.regioncodekotlinapp.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.jonli.regioncodekotlinapp.model.RegionCodeRepository
import com.jonli.regioncodekotlinapp.viewmodel.ViewModelFactory

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance(application, RegionCodeRepository.getInstance(application))).get(viewModelClass)
