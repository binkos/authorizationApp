package com.pracel.authorizationapp.home.model

import androidx.compose.runtime.Stable
import com.pracel.mvi.State

@Stable
data class HomeState(
    val accounts: List<Account> = emptyList()
) : State