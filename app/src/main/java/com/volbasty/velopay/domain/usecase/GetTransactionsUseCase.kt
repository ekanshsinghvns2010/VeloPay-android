
package com.volbasty.velopay.domain.usecase

import com.volbasty.velopay.domain.model.Transaction
import com.volbasty.velopay.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

/**
 * Provides the transaction stream to the presentation layer.
 */
class GetTransactionsUseCase(
    private val repository: TransactionRepository
) {
    operator fun invoke(): Flow<List<Transaction>> {
        return repository.observeTransactions()
    }
}
