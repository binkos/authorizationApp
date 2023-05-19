package com.pracel.authorizationapp.transaction.details.screen.model

import com.pracel.mvi.Event

internal sealed class TransactionDetailsEvent : Event {

//    class OnDetailsRequested : TransactionDetailsEvent()

    object OnAddButtonClicked : TransactionDetailsEvent()
}