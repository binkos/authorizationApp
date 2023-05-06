package com.uladzislau_pravalenak.authorizationapp.app

import android.app.Application
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentProviderImpl
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.impl.di.TransactionsComponentProviderImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class AppApplication : Application(),
    AccountComponentProvider by AccountComponentProviderImpl(Dispatchers),
    TransactionsComponentProvider by TransactionsComponentProviderImpl()