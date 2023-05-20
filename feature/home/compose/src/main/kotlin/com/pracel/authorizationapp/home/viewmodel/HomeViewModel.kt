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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take

class HomeViewModel(
//    private val accountsRepository: AccountsRepository,
    lastTransactionsUseCase: LastTransactionsUseCase
) : MVIViewModel<HomeState, HomeAction, HomeEvent>(HomeState()) {

    init {
//        val accounts =
//            viewModelScope.async { accountsRepository.getAccounts().map(::mapAccountToUi) }

        lastTransactionsUseCase
            .getLastTransactions()
            .map { transitions -> transitions.map(::mapTransactionToUi) }
            .onEach {
                val newState = state.copy(accounts = emptyList(), transactions = it)
                updateState { newState }
            }
            .launchIn(viewModelScope)
    }

    override fun handleEvents(event: HomeEvent) {
//        when (event) {
//            else -> {}
//        }
    }
}