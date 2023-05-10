package com.pracel.mvi

interface MVIProvider<S : State, A : Action, E : Event> : StateHandler<S>, ActionHandler<A> {

    fun handleEvents(event: E)
}