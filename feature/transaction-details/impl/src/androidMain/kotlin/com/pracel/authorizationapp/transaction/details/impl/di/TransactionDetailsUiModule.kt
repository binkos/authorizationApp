package com.pracel.authorizationapp.transaction.details.impl.di

import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsUiModule
import com.pracel.authorizationapp.transaction.details.screen.di.TransactionDetailsUiModuleImpl

actual fun TransactionDetailsUiModule(): TransactionDetailsUiModule = TransactionDetailsUiModuleImpl()
