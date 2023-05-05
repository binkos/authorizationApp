package com.pracel.authorizationapp.accounts.api.di

import com.pracel.authorizationapp.accounts.api.AccountsRepository

interface AccountModule {
    val repository: AccountsRepository
}