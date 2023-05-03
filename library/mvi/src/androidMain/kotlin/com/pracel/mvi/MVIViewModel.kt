package com.pracel.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class MVIViewModel<S : State, A : Action, E : Event>(
    initialState: S
) : ViewModel(), MVIProvider<S, A, E> {

    private val _stateFlow: MutableStateFlow<S> = MutableStateFlow(initialState)
    override val stateFlow: StateFlow<S> = _stateFlow.asStateFlow()

    override val state: S
        get() = stateFlow.value

    private val _actions: MutableSharedFlow<A> = MutableSharedFlow()
    override val actions: SharedFlow<A> = _actions.asSharedFlow()

    override fun updateState(reduce: S.() -> S) {
        _stateFlow.update(reduce)
    }


    override suspend fun sendAction(action: A) {
        _actions.emit(action)
    }
}