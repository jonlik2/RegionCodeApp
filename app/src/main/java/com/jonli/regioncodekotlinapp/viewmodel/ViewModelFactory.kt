package com.jonli.regioncodekotlinapp.viewmodel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jonli.regioncodekotlinapp.model.RegionCodeRepository
import java.lang.IllegalArgumentException

class ViewModelFactory private constructor(
        private val application: Application,
        private val repository: RegionCodeRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(CodeViewModel::class.java) ->
                    CodeViewModel(application, repository)
                isAssignableFrom(RegionViewModel::class.java) ->
                    RegionViewModel(application, repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T


    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application, repository: RegionCodeRepository): ViewModelFactory {
            return if (INSTANCE == null) {
                ViewModelFactory(application, repository)
            } else {
                INSTANCE as ViewModelFactory
            }
        }
    }

}