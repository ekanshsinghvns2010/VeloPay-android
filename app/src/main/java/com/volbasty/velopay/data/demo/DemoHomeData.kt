
package com.volbasty.velopay.data.demo

import com.volbasty.velopay.ui.home.VeloPayUiState

/**
 * Fictional display data for the VeloPay prototype.
 *
 * These values are not yet derived from DemoTransactions,
 * DemoAccounts, or DemoCommitments.
 */
object DemoHomeData {

    val initialState = VeloPayUiState(
        isDemoMode = true,
        totalBalancePaise = 2_485_000L,
        monthlyIncomePaise = 1_200_000L,
        monthlyExpensesPaise = 845_000L,
        upcomingCommitmentPaise = 120_000L,
        upcomingCommitmentDays = 3,
        topExpenseCategory = "Food",
        topExpensePercentage = 32,
        isLoading = false,
        errorMessage = null
    )
}
