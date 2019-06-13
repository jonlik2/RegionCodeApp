package com.jonli.regioncodekotlinapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import com.jonli.regioncodekotlinapp.repository.Repository
import com.jonli.regioncodekotlinapp.viewmodel.ViewModelFactory

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance(application, Repository.getInstance(application))).get(viewModelClass)
