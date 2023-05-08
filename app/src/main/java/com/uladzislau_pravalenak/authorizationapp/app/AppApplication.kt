package com.uladzislau_pravalenak.authorizationapp.app

import android.app.Application
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentProviderImpl
import com.pracel.authorizationapp.home.api.di.HomeComponent
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.api.di.HomeLastTransactionsModule
import com.pracel.authorizationapp.home.impl.di.HomeComponent
import com.pracel.authorizationapp.home.impl.di.HomeComponentProviderImpl
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.impl.di.TransactionsComponentProviderImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class AppApplication : Application(),
    AccountComponentProvider by AccountComponentProviderImpl(Dispatchers),
    TransactionsComponentProvider by TransactionsComponentProviderImpl(),
    HomeComponentProvider by HomeComponentProviderImpl()