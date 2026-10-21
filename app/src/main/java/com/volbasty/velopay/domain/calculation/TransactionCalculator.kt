
package com.volbasty.velopay.domain.calculation

import com.volbasty.velopay.domain.model.Transaction
import com.volbasty.velopay.domain.model.TransactionType

data class TransactionTotals(
    val incomePaise: Long,
    val expensesPaise: Long,
    val transferPaise: Long
)

object TransactionCalculator {

    fun calculateTotals(
        transactions: List<Transaction>
    ): TransactionTotals {
        var income = 0L
        var expenses = 0L
        var transfers = 0L

        transactions.forEach { transaction ->
            when (transaction.type) {
                TransactionType.INCOME -> {
                    income = Math.addExact(income, transaction.amountPaise)
                }

                TransactionType.EXPENSE -> {
                    expenses = Math.addExact(expenses, transaction.amountPaise)
                }

                TransactionType.TRANSFER -> {
                    transfers = Math.addExact(transfers, transaction.amountPaise)
                }
            }
        }

        return TransactionTotals(
            incomePaise = income,
            expensesPaise = expenses,
            transferPaise = transfers
        )
    }

    fun calculateNetIncomePaise(
        transactions: List<Transaction>
    ): Long {
        val totals = calculateTotals(transactions)

        return Math.subtractExact(
            totals.incomePaise,
            totals.expensesPaise
        )
    }
}
