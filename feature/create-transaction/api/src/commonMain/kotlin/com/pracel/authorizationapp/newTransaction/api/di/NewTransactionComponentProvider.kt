package com.pracel.authorizationapp.newTransaction.api.di

interface NewTransactionComponentProvider {
    fun provideNewTransactionComponent(): NewTransactionComponent
    val provideNewTransactionComponent: NewTransactionComponent
}