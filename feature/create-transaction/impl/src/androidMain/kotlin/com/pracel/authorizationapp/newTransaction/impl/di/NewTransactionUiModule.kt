package com.pracel.authorizationapp.newTransaction.impl.di

import com.pracel.authorizationapp.newTransaction.screen.di.NewTransactionUiModuleImpl
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionUiModule

actual fun NewTransactionUiModule(): NewTransactionUiModule = NewTransactionUiModuleImpl()
