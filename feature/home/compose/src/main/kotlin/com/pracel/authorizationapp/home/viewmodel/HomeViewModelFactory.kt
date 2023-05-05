package com.pracel.authorizationapp.home.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider

class HomeViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val application = extras[APPLICATION_KEY] as Application
        val repository = (application as AccountComponentProvider)
            .provideAccountComponent()
            .repository

        return HomeViewModel(repository) as T
    }
}