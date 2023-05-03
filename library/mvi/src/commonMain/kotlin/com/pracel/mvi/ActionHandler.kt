package com.pracel.mvi

import kotlinx.coroutines.flow.SharedFlow

interface ActionHandler<A : Action> {

    val actions: SharedFlow<A>

    suspend fun sendAction(action: A)
}