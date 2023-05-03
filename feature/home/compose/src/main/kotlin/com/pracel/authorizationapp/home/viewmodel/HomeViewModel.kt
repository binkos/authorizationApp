package com.pracel.authorizationapp.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.accounts.api.AccountsRepositoryApi
import com.pracel.authorizationapp.home.model.HomeAction
import com.pracel.authorizationapp.home.model.HomeEvent
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val accountsRepository: AccountsRepositoryApi
) : MVIViewModel<HomeState, HomeAction, HomeEvent>(HomeState()) {

    init {
        viewModelScope.launch {
            val accounts = accountsRepository.getAccounts()
//            updateState { copy(accounts = accounts) }
        }
    }

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            else -> {}
        }
    }

//    val state: MutableStateFlow<String>
}