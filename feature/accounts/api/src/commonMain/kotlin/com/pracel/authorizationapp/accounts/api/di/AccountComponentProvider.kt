package com.pracel.authorizationapp.accounts.api.di

import com.pracel.authorizationapp.core.di.ComponentProvider

interface AccountComponentProvider {
    fun provideAccountComponent(): AccountsComponent
}