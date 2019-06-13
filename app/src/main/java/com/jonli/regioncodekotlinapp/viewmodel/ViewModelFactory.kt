package com.jonli.regioncodekotlinapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jonli.regioncodekotlinapp.code.CodeViewModel
import com.jonli.regioncodekotlinapp.repository.Repository
import com.jonli.regioncodekotlinapp.region.RegionViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(
        private val application: Application,
        private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(CodeViewModel::class.java) ->
                    CodeViewModel(application)
                isAssignableFrom(RegionViewModel::class.java) ->
                    RegionViewModel(application, repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T


    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application, repository: Repository): ViewModelFactory {
            return if (INSTANCE == null) {
                ViewModelFactory(application, repository)
            } else {
                INSTANCE as ViewModelFactory
            }
        }
    }

}