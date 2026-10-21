
package com.volbasty.velopay.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volbasty.velopay.domain.calculation.TransactionCalculator
import com.volbasty.velopay.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    repository: TransactionRepository
) : ViewModel() {

    val uiState = repository.observeTransactions()
        .map { transactions ->
            val totals = TransactionCalculator.calculateTotals(transactions)

            VeloPayUiState(
                isDemoMode = true,
                monthlyIncomePaise = totals.incomePaise,
                monthlyExpensesPaise = totals.expensesPaise
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = VeloPayUiState(isLoading = true)
        )
}
