package com.pracel.authorizationapp.accounts.api.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.pracel.authorizationapp.accounts.api.Account
import com.pracel.authorizationapp.accounts.api.AccountCurrency
import com.pracel.authorizationapp.accounts.api.AccountType

@Immutable
data class AccountModel(
    // TODO: create sealed class Wrapper to have opportunity to load remote and Local images
    val icon: ImageVector,
    val value: String,
    val type: String,
    // TODO: Remove Color and use Enum instead as it doesn't support theming
    val color: Color
)

fun mapAccountToUi(acc: Account): AccountModel = with(acc) {
    val icon = when (type) {
        AccountType.CreditCard -> Icons.Filled.CreditCard
        AccountType.DebitCard -> Icons.Filled.AccountBalanceWallet
        AccountType.Wallet -> Icons.Filled.AccountBalanceWallet
        AccountType.CryptoWallet -> Icons.Filled.AccountBalanceWallet
        AccountType.Cash -> Icons.Filled.Money
        AccountType.Other -> Icons.Filled.Money
    }
    val currency = when (currency) {
        AccountCurrency.Dollar -> '$'
        AccountCurrency.Euro -> '€'
        AccountCurrency.Ruble -> '₽'
        AccountCurrency.Other -> ""
    }

    return AccountModel(icon, "$currency$value", "${type.name}($currency)", Color.Gray)
}