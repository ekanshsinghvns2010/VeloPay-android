
package com.volbasty.velopay.domain.model

data class DemoCommitment(
    val id: String,
    val title: String,
    val amountPaise: Long,
    val dueDateEpochMillis: Long,
    val isPaid: Boolean = false,
    val linkedAccountId: String? = null
) {
    init {
        require(id.isNotBlank()) {
            "Commitment ID cannot be blank."
        }
        require(title.isNotBlank()) {
            "Commitment title cannot be blank."
        }
        require(amountPaise > 0L) {
            "Commitment amount must be positive."
        }
        require(linkedAccountId == null || linkedAccountId.isNotBlank()) {
            "Linked account ID cannot be blank."
        }
    }
}
