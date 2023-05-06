package com.pracel.authorizationapp.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pracel.authorizationapp.home.compose.R
import com.pracel.authorizationapp.transactions.api.model.TransactionModel

@Composable
internal fun LastTransactions(
    modifier: Modifier = Modifier,
    transactions: List<TransactionModel>,
    transactionsUi: @Composable (transaction: TransactionModel) -> Unit
) {
    Column(modifier = modifier) {
        Header(R.string.last_transactions)
        TransactionsBlock(
            transactions = transactions,
            transactionsUi = transactionsUi
        )
    }
}

@Composable
private fun TransactionsBlock(
    modifier: Modifier = Modifier,
    transactions: List<TransactionModel>,
    transactionsUi: @Composable (transaction: TransactionModel) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = Modifier)
        }
        items(transactions) { transaction -> transactionsUi(transaction) }
        item {
            Spacer(modifier = Modifier)
        }
    }
}

@Preview
@Composable
fun LastTransactionsPreview() {
//    val transactions = listOf(
//        TransactionModel(Icons.Filled.RestaurantMenu, "Restaurant", "Cash", "-$205"),
//        TransactionModel(Icons.Filled.HealthAndSafety, "Health", "Cash", "-$5"),
//        TransactionModel(Icons.Filled.DirectionsBus, "Transport", "Credit Card", "+$5"),
//        TransactionModel(Icons.Filled.SportsEsports, "VideoGames", "Cash", "-$20"),
//        TransactionModel(Icons.Filled.DirectionsCar, "Car", "Debit Card", "-$15"),
//        TransactionModel(Icons.Filled.AirplanemodeActive, "Traveling", "Cash", "-$35"),
//        TransactionModel(Icons.Filled.ShoppingCart, "Food Shop", "Crypto Wallet", "-$45"),
//    )
//    AuthorizationAppTheme {
//        Surface {
//            LastTransactions(
//                transactions = transactions,
//                transactionsUiModule = object : TransactionsUiModule {
//                    @Composable
//                    override fun RenderSingleTransaction(
//                        modifier: Modifier,
//                        transactionModel: TransactionModel
//                    ) {
//                        TODO("Not yet implemented")
//                    }
//
//                }
//            )
//        }
//    }
}