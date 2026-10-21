
package com.volbasty.velopay.data.demo

import com.volbasty.velopay.domain.model.Transaction
import com.volbasty.velopay.domain.model.TransactionType

object DemoTransactions {

    // Fixed timestamps keep the sample data deterministic.
    // These dates are illustrative, not real user activity.
    private const val DAY_MS = 86_400_000L

    private const val DEMO_NOW = 1_782_000_000_000L

    val transactions: List<Transaction> = listOf(
        Transaction(
            id = "demo-income-001",
            title = "Monthly salary",
            category = "Salary",
            amountPaise = 1_200_000L,
            type = TransactionType.INCOME,
            dateEpochMillis = DEMO_NOW - DAY_MS * 5,
            accountId = "demo-account-main"
        ),
        Transaction(
            id = "demo-expense-001",
            title = "Groceries",
            category = "Food",
            amountPaise = 2_500_000L,
            type = TransactionType.EXPENSE,
            dateEpochMillis = DEMO_NOW - DAY_MS * 2,
            accountId = "demo-account-main"
        ),
        Transaction(
            id = "demo-expense-002",
            title = "Transport",
            category = "Travel",
            amountPaise = 1_500_000L,
            type = TransactionType.EXPENSE,
            dateEpochMillis = DEMO_NOW - DAY_MS * 3,
            accountId = "demo-account-main"
        ),
        Transaction(
            id = "demo-expense-003",
            title = "Coffee",
            category = "Food",
            amountPaise = 350_000L,
            type = TransactionType.EXPENSE,
            dateEpochMillis = DEMO_NOW - DAY_MS,
            accountId = "demo-account-main"
        ),
        Transaction(
            id = "demo-transfer-001",
            title = "Move to savings",
            category = "Transfer",
            amountPaise = 500_000L,
            type = TransactionType.TRANSFER,
            dateEpochMillis = DEMO_NOW - DAY_MS * 4,
            accountId = "demo-account-main",
            note = "Demo transfer; not a real payment."
        )
    )
}
