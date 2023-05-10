package com.pracel.authorizationapp.transactions.api.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

//TODO Don't share it through DI in future as it doesn't give a lot of profit
// may be it is good idea to share it by DI as
@Immutable
data class TransactionModel(
    val icon: ImageVector = Icons.Default.Face,
    val category: String = "",
    val source: String = "",
    val value: String = ""
)

fun mapTransactionToUi(transaction: Transaction): TransactionModel = with(transaction){
    val value = buildString {
        val sign = when (type){
            TransactionType.Income -> '+'
            TransactionType.Outcome -> '-'
        }
        append(sign)
        append('$')
        append(amount)
    }

    TransactionModel(
        category = category,
        source = source,
        value = value
    )
}
