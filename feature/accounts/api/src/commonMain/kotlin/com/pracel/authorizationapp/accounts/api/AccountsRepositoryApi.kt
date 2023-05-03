package com.pracel.authorizationapp.accounts.api

interface AccountsRepositoryApi {

    suspend fun getAccounts(): List<Account>
}