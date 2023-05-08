package com.pracel.authorizationapp.transactions.impl.repository

import com.pracel.authorizationapp.transactions.api.model.Transaction
import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class TransactionsRepositoryImpl(private val dispatchers: Dispatchers) :
    TransactionsRepository {
    override suspend fun getAllTransactions(): List<Transaction> {
        return withContext(dispatchers.IO) {
            listOf(
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                Transaction(TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
                Transaction(TransactionType.Income, "10", "Cash", "Travel"),
                Transaction(TransactionType.Income, "20", "Wallet", "Transportation"),
                Transaction(TransactionType.Income, "30", "CryptoWallet", "School"),
                Transaction(TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
                )
        }
    }
}