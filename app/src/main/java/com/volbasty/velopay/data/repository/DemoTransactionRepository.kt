
package com.volbasty.velopay.data.repository

import com.volbasty.velopay.data.demo.DemoTransactions
import com.volbasty.velopay.domain.model.Transaction
import com.volbasty.velopay.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first

/**
 * In-memory repository for the VeloPay prototype.
 *
 * Changes exist only while the process remains alive.
 * This is not permanent storage.
 */
class DemoTransactionRepository(
    initialTransactions: List<Transaction> = DemoTransactions.transactions
) : TransactionRepository {

    private val transactions =
        MutableStateFlow(initialTransactions.toList())

    override fun observeTransactions(): Flow<List<Transaction>> =
        transactions.asStateFlow()

    override suspend fun getTransactionById(
        transactionId: String
    ): Transaction? {
        return transactions.value.firstOrNull { it.id == transactionId }
    }

    override suspend fun addTransaction(
        transaction: Transaction
    ) {
        require(transactions.value.none { it.id == transaction.id }) {
            "A transaction with this ID already exists."
        }

        transactions.value = transactions.value + transaction
    }

    override suspend fun updateTransaction(
        transaction: Transaction
    ) {
        val current = transactions.value
        val index = current.indexOfFirst { it.id == transaction.id }

        require(index >= 0) {
            "Cannot update a transaction that does not exist."
        }

        transactions.value = current.toMutableList().apply {
            set(index, transaction)
        }
    }

    override suspend fun deleteTransaction(
        transactionId: String
    ) {
        transactions.value =
            transactions.value.filterNot { it.id == transactionId }
    }
}
