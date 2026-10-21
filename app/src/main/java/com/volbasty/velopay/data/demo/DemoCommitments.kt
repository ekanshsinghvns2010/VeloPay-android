
package com.volbasty.velopay.data.demo

import com.volbasty.velopay.domain.model.DemoCommitment

object DemoCommitments {

    // Fixed illustrative timestamp for deterministic demo data.
    private const val DEMO_NOW = 1_782_000_000_000L
    private const val DAY_MS = 86_400_000L

    val commitments: List<DemoCommitment> = listOf(
        DemoCommitment(
            id = "demo-commitment-001",
            title = "Utility bill",
            amountPaise = 120_000L,
            dueDateEpochMillis = DEMO_NOW + DAY_MS * 3,
            isPaid = false,
            linkedAccountId = "demo-account-main"
        )
    )
}
