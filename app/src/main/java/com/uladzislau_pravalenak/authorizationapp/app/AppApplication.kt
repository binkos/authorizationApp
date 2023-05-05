package com.uladzislau_pravalenak.authorizationapp.app

import android.app.Application
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentDependencies
import com.pracel.authorizationapp.accounts.impl.di.AccountsComponent
import com.uladzislau_pravalenak.authorizationapp.app.account.AccountComponentProviderImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class AppApplication : Application(),
    AccountComponentProvider by AccountComponentProviderImpl()