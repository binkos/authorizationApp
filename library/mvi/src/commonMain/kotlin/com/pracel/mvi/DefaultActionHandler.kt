package com.pracel.mvi

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class DefaultActionHandler<A : Action> : ActionHandler<A> {

    private val _actions: MutableSharedFlow<A> = MutableSharedFlow()
    override val actions: SharedFlow<A> = _actions.asSharedFlow()

    override suspend fun sendAction(action: A) {
        _actions.emit(action)
    }
}