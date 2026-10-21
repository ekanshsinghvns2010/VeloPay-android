
package com.volbasty.velopay.domain.usecase

import com.volbasty.velopay.domain.model.FinancialAccount
import com.volbasty.velopay.domain.model.Transaction
import com.volbasty.velopay.domain.model.TransactionType

class CalculateAccountBalanceUseCase {

    /**
     * Calculates a balance using income and expenses assigned
     * directly to this account.
     *
     * Transfers are deliberately excluded until transactions
     * support explicit source and destination account IDs.
     */
    operator fun invoke(
        account: FinancialAccount,
        transactions: List<Transaction>
    ): Long {
        var balance = account.openingBalancePaise

        transactions
            .asSequence()
            .filter { it.accountId == account.id }
            .forEach { transaction ->
                balance = when (transaction.type) {
                    TransactionType.INCOME ->
                        Math.addExact(balance, transaction.amountPaise)

                    TransactionType.EXPENSE ->
                        Math.subtractExact(balance, transaction.amountPaise)

                    TransactionType.TRANSFER ->
                        balance
                }
            }

        return balance
    }
}
