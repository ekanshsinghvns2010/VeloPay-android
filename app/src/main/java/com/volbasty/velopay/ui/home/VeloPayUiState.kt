
package com.volbasty.velopay.ui.home

data class VeloPayUiState(
    val isDemoMode: Boolean = true,
    val totalBalancePaise: Long = 2_485_000,
    val monthlyIncomePaise: Long = 1_200_000,
    val monthlyExpensesPaise: Long = 845_000,
    val upcomingCommitmentPaise: Long = 120_000,
    val upcomingCommitmentDays: Int = 3,
    val topExpenseCategory: String = "Food",
    val topExpensePercentage: Int = 32,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
