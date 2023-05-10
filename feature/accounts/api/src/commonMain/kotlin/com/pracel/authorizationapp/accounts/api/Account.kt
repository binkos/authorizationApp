package com.pracel.authorizationapp.accounts.api

data class Account(
    val name: String,
    val value: String,
    val currency: AccountCurrency,
    val type: AccountType
)

enum class AccountCurrency {
    Dollar,
    Euro,
    Ruble,
    Other
}

enum class AccountType {
    CreditCard,
    DebitCard,
    Wallet,
    CryptoWallet,
    Cash,
    Other
}
