
package com.volbasty.velopay.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volbasty.velopay.core.design.VeloPayElectricBlue
import com.volbasty.velopay.core.format.MoneyFormatter

@Composable
fun FinancialSummaryCard(
    title: String,
    amountPaise: Long,
    modifier: Modifier = Modifier,
    highlighted: Boolean = false,
    showDecimals: Boolean = false
) {
    val amountText = if (showDecimals) {
        MoneyFormatter.formatRupees(amountPaise)
    } else {
        MoneyFormatter.formatWholeRupees(amountPaise)
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = if (highlighted) {
            VeloPayElectricBlue.copy(alpha = 0.13f)
        } else {
            MaterialTheme.colorScheme.surface
        }
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0f))
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = amountText,
                style = MaterialTheme.typography.headlineMedium,
                color = if (highlighted) {
                    VeloPayElectricBlue
                } else {
                    MaterialTheme.colorScheme.onSurface
                }
            )
        }
    }
}
