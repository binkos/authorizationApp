package com.pracel.authorizationapp.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.accounts.api.AccountsRepository
import com.pracel.authorizationapp.home.model.HomeAction
import com.pracel.authorizationapp.home.model.HomeEvent
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.authorizationapp.home.model.mapToUi
import com.pracel.authorizationapp.transactions.api.model.TransactionModel
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(
    private val accountsRepository: AccountsRepository,
    private val transactionsRepository: TransactionsRepository,
) : MVIViewModel<HomeState, HomeAction, HomeEvent>(HomeState()) {

    init {
        viewModelScope.launch {
            val accounts = async { accountsRepository.getAccounts().map(::mapToUi) }
            val transactions = async { transactionsRepository.getAllTransactions().map { TransactionModel() } }

            val newState = state.copy(accounts = accounts.await(), transactions = transactions.await())

            updateState { newState }
        }
    }

    override fun handleEvents(event: HomeEvent) {
//        when (event) {
//            else -> {}
//        }
    }

//    val state: MutableStateFlow<String>
}