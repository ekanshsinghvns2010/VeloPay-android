
package com.volbasty.velopay.domain.model

enum class TransactionType {
    INCOME,
    EXPENSE,
    TRANSFER
}

data class Transaction(
    val id: String,
    val title: String,
    val category: String,
    val amountPaise: Long,
    val type: TransactionType,
    val dateEpochMillis: Long,
    val accountId: String,
    val note: String? = null
) {
    init {
        require(id.isNotBlank()) {
            "Transaction ID cannot be blank."
        }
        require(title.isNotBlank()) {
            "Transaction title cannot be blank."
        }
        require(amountPaise > 0L) {
            "Transaction amount must be positive."
        }
        require(accountId.isNotBlank()) {
            "Account ID cannot be blank."
        }
    }
}
