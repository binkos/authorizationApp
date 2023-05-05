package com.pracel.authorizationapp.accounts.api

interface AccountsRepository {

    suspend fun getAccounts(): List<Account>
}