package com.pracel.authorizationapp.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.accounts.api.AccountsRepository
import com.pracel.authorizationapp.accounts.api.model.mapAccountToUi
import com.pracel.authorizationapp.home.api.domain.LastTransactionsUseCase
import com.pracel.authorizationapp.home.model.HomeAction
import com.pracel.authorizationapp.home.model.HomeEvent
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.authorizationapp.transactions.api.model.mapTransactionToUi
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(
    private val accountsRepository: AccountsRepository,
    private val lastTransactionsUseCase: LastTransactionsUseCase
) : MVIViewModel<HomeState, HomeAction, HomeEvent>(HomeState()) {

    init {
        viewModelScope.launch {
            val accounts = async { accountsRepository.getAccounts().map(::mapAccountToUi) }
            val transactions =
                async { lastTransactionsUseCase.getLastTransactions().map(::mapTransactionToUi) }

            val newState =
                state.copy(accounts = accounts.await(), transactions = transactions.await())
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