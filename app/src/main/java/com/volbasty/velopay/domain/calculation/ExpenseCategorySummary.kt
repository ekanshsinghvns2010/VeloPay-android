
package com.volbasty.velopay.domain.calculation

import com.volbasty.velopay.domain.model.Transaction
import com.volbasty.velopay.domain.model.TransactionType

data class ExpenseCategory(
    val name: String,
    val totalPaise: Long,
    val percentage: Int
)

object ExpenseCategorySummary {

    /**
     * Groups expenses by category and calculates their share
     * of all expenses in the supplied transaction list.
     *
     * Pass only the intended reporting period's transactions.
     */
    fun calculate(
        transactions: List<Transaction>
    ): List<ExpenseCategory> {
        val expenses = transactions.filter {
            it.type == TransactionType.EXPENSE
        }

        val totalExpenses = expenses.fold(0L) { total, transaction ->
            Math.addExact(total, transaction.amountPaise)
        }

        if (totalExpenses == 0L) return emptyList()

        return expenses
            .groupBy { it.category.trim().ifBlank { "Uncategorized" } }
            .map { (category, items) ->
                val categoryTotal = items.fold(0L) { total, transaction ->
                    Math.addExact(total, transaction.amountPaise)
                }

                val percentage = (
                    categoryTotal.toDouble() * 100.0 / totalExpenses.toDouble()
                ).toInt()

                ExpenseCategory(
                    name = category,
                    totalPaise = categoryTotal,
                    percentage = percentage
                )
            }
            .sortedByDescending { it.totalPaise }
    }
}
