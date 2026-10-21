
package com.volbasty.velopay.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.volbasty.velopay.core.design.VeloPayElectricBlue
import com.volbasty.velopay.core.design.VeloPayMutedText
import com.volbasty.velopay.navigation.VeloPayDestination

private fun VeloPayDestination.icon(): ImageVector =
    when (this) {
        VeloPayDestination.HOME -> Icons.Filled.AccountBalanceWallet
        VeloPayDestination.ACTIVITY -> Icons.Filled.ReceiptLong
        VeloPayDestination.PLAN -> Icons.Filled.Tune
        VeloPayDestination.INSIGHTS -> Icons.Filled.Insights
    }

@Composable
fun VeloPayBottomNavigation(
    selectedDestination: VeloPayDestination,
    onDestinationSelected: (VeloPayDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        VeloPayDestination.bottomNavigationItems.forEach { destination ->
            NavigationBarItem(
                selected = selectedDestination == destination,
                onClick = {
                    onDestinationSelected(destination)
                },
                icon = {
                    Icon(
                        imageVector = destination.icon(),
                        contentDescription = destination.label
                    )
                },
                label = {
                    Text(destination.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = VeloPayElectricBlue,
                    selectedTextColor = VeloPayElectricBlue,
                    unselectedIconColor = VeloPayMutedText,
                    unselectedTextColor = VeloPayMutedText,
                    indicatorColor = VeloPayElectricBlue.copy(alpha = 0.12f)
                )
            )
        }
    }
}
