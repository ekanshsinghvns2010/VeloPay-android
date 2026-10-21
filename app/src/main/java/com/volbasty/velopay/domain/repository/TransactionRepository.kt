
package com.volbasty.velopay.domain.repository

import com.volbasty.velopay.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

/**
 * Contract for reading and managing transactions.
 *
 * A local implementation will be added later.
 * This interface does not itself persist any data.
 */
interface TransactionRepository {

    fun observeTransactions(): Flow<List<Transaction>>

    suspend fun getTransactionById(
        transactionId: String
    ): Transaction?

    suspend fun addTransaction(
        transaction: Transaction
    )

    suspend fun updateTransaction(
        transaction: Transaction
    )

    suspend fun deleteTransaction(
        transactionId: String
    )
}
