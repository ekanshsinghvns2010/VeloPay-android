
package com.volbasty.velopay.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.volbasty.velopay.core.design.VeloPayElectricBlue

@Composable
fun ExpenseInsightCard(
    category: String,
    percentage: Int,
    modifier: Modifier = Modifier
) {
    require(percentage in 0..100) {
        "Percentage must be between 0 and 100."
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = VeloPayElectricBlue.copy(alpha = 0.10f)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "SPENDING INSIGHT",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "$category accounts for $percentage% of recorded expenses.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = "Based on the available transaction data.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
