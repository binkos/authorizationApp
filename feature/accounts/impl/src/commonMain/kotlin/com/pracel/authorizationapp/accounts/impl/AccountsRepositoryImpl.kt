package com.pracel.authorizationapp.accounts.impl

import com.pracel.authorizationapp.accounts.api.Account
import com.pracel.authorizationapp.accounts.api.AccountCurrency
import com.pracel.authorizationapp.accounts.api.AccountType
import com.pracel.authorizationapp.accounts.api.AccountsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class AccountsRepositoryImpl(
    private val dispatchers: Dispatchers
) : AccountsRepository {

    override suspend fun getAccounts(): List<Account> {
        return withContext(dispatchers.IO) {
            listOf(
                Account("Nika", "5000", AccountCurrency.Dollar, AccountType.Cash),
                Account("TBC", "3200", AccountCurrency.Ruble, AccountType.CreditCard),
                Account("Trust Wallet", "500", AccountCurrency.Dollar, AccountType.CryptoWallet),
            )
        }
    }
}