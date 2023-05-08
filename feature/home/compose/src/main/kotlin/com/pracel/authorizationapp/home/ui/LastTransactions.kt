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
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier)
        transactions.forEach { transaction -> transactionsUi(transaction) }
        Spacer(modifier = Modifier)
    }
}