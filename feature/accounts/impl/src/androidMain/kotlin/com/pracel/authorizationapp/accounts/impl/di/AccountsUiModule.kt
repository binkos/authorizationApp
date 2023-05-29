package com.pracel.authorizationapp.accounts.impl.di

import com.pracel.authorizationapp.accounts.api.di.AccountsUiModule

internal actual fun AccountsUiModule(): AccountsUiModule =
    com.pracel.authorizationapp.accounts.di.AccountsUiModule()