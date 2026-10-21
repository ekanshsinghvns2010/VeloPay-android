
package com.volbasty.velopay.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volbasty.velopay.data.demo.DemoCommitments
import com.volbasty.velopay.data.demo.DemoTransactions
import com.volbasty.velopay.domain.calculation.ExpenseCategorySummary
import com.volbasty.velopay.domain.model.TransactionType
import com.volbasty.velopay.ui.components.DemoModeBanner
import com.volbasty.velopay.ui.components.ExpenseInsightCard
import com.volbasty.velopay.ui.components.FinancialSummaryCard
import com.volbasty.velopay.ui.components.RecentTransactionItem
import com.volbasty.velopay.ui.components.UpcomingCommitmentCard
import com.volbasty.velopay.ui.components.VeloPayHeader
import com.volbasty.velopay.core.format.MoneyFormatter

@Composable
fun HomeScreen(
    uiState: VeloPayUiState,
    onSettingsClick: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    val demoTransactions = DemoTransactions.transactions
    val topCategory = ExpenseCategorySummary
        .calculate(demoTransactions)
        .firstOrNull()

    val upcomingCommitment = DemoCommitments.commitments
        .firstOrNull { !it.isPaid }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(contentPadding)
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        VeloPayHeader(onSettingsClick = onSettingsClick)

        DemoModeBanner()

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "TOTAL ACCOUNT BALANCE",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            FinancialSummaryCard(
                title = "Your financial overview",
                amountPaise = uiState.totalBalancePaise,
                highlighted = true,
                showDecimals = false
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "This month",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            FinancialSummaryCard(
                title = "Income",
                amountPaise = uiState.monthlyIncomePaise
            )

            FinancialSummaryCard(
                title = "Expenses",
                amountPaise = uiState.monthlyExpensesPaise
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Upcoming commitments",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            if (upcomingCommitment != null) {
                UpcomingCommitmentCard(
                    title = upcomingCommitment.title,
                    amountPaise = upcomingCommitment.amountPaise,
                    dueDateLabel = "Upcoming · demo schedule"
                )
            } else {
                Text(
                    text = "No upcoming commitments.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Spending insight",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            if (topCategory != null) {
                ExpenseInsightCard(
                    category = topCategory.name,
                    percentage = topCategory.percentage
                )
            } else {
                Text(
                    text = "Add demo transactions to see spending insights.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Recent transactions",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            demoTransactions
                .sortedByDescending { it.dateEpochMillis }
                .take(5)
                .forEach { transaction ->
                    RecentTransactionItem(transaction = transaction)
                }
        }

        Text(
            text = "All figures are fictional and for demonstration only.",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
