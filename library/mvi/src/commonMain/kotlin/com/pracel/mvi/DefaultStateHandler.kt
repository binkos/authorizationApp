package com.pracel.mvi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DefaultStateHandler<S : State>(
    initialState: S
) : StateHandler<S> {

    private val _stateFlow: MutableStateFlow<S> = MutableStateFlow(initialState)
    override val stateFlow: StateFlow<S>
        get() = _stateFlow.asStateFlow()

    override val state: S
        get() = stateFlow.value

    override fun updateState(reduce: S.() -> S) {
        _stateFlow.update(reduce)
    }
}