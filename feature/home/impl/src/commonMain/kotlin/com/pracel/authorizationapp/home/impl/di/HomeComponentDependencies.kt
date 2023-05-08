package com.pracel.authorizationapp.home.impl.di

import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository

interface HomeComponentDependencies {
    val repository: TransactionsRepository

    companion object {
        operator fun invoke(repository: TransactionsRepository): HomeComponentDependencies {
            return object : HomeComponentDependencies {
                override val repository: TransactionsRepository = repository
            }
        }
    }
}