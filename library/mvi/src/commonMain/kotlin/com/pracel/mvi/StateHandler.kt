package com.pracel.mvi

import kotlinx.coroutines.flow.StateFlow

interface StateHandler<S: State> {

    val stateFlow: StateFlow<S>
    val state: S

    fun updateState(reduce: S.() -> S)
}