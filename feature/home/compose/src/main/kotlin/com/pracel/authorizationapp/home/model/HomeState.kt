package com.pracel.authorizationapp.home.model

import androidx.compose.runtime.Stable
import com.pracel.authorizationapp.accounts.api.model.AccountModel
import com.pracel.authorizationapp.transactions.api.model.TransactionModel
import com.pracel.mvi.State

@Stable
data class HomeState(
    val accounts: List<AccountModel> = emptyList(),
    val transactions: List<TransactionModel> = emptyList()
) : State