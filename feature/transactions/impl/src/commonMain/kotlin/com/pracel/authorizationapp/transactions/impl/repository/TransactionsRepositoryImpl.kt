package com.pracel.authorizationapp.transactions.impl.repository

import com.pracel.authorizationapp.transactions.api.model.NewTransaction
import com.pracel.authorizationapp.transactions.api.model.Transaction
import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.LinkedList

internal class TransactionsRepositoryImpl(
    private val dispatchers: Dispatchers
) : TransactionsRepository {
    private val transactions: LinkedList<Transaction> = LinkedList(
        listOf(
            Transaction(0, TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
            Transaction(1, TransactionType.Income, "10", "Cash", "Travel"),
            Transaction(2, TransactionType.Income, "20", "Wallet", "Transportation"),
            Transaction(3, TransactionType.Income, "30", "CryptoWallet", "School"),
            Transaction(4, TransactionType.Income, "45", "DebitCard(*5111)", "Education"),
            Transaction(5, TransactionType.Income, "100", "DebitCard(*8644)", "Health"),
            Transaction(6, TransactionType.Income, "10", "Cash", "Travel"),
            Transaction(7, TransactionType.Income, "20", "Wallet", "Transportation"),
            Transaction(8, TransactionType.Income, "30", "CryptoWallet", "School"),
        )
    )

    private val transactionsFlow: MutableStateFlow<List<Transaction>> =
        MutableStateFlow(transactions.toList())

    override fun getAllTransactions(): Flow<List<Transaction>> = transactionsFlow

    override suspend fun addTransaction(transaction: NewTransaction) {
        withContext(dispatchers.IO) {
            val newTransaction = Transaction(
                Random.nextInt(0, Int.MAX_VALUE),
                transaction.type,
                transaction.amount,
                transaction.source,
                transaction.category
            )
            transactions.addFirst(newTransaction)

            transactionsFlow.emit(transactions.toList())
        }
    }

    override suspend fun getTransactionById(id: Int): Transaction? {
        return withContext(dispatchers.IO) {
            transactions.firstOrNull { it.id == id }
        }
    }
}