
package com.volbasty.velopay

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.volbasty.velopay.core.design.VeloPayTheme
import com.volbasty.velopay.data.repository.DemoTransactionRepository
import com.volbasty.velopay.navigation.VeloPayDestination
import com.volbasty.velopay.ui.components.VeloPayBottomNavigation
import com.volbasty.velopay.ui.home.HomeScreen
import com.volbasty.velopay.ui.home.HomeViewModel
import com.volbasty.velopay.ui.home.HomeViewModelFactory

@Composable
fun VeloPayApp() {
    val repository = remember {
        DemoTransactionRepository()
    }

    val homeViewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(repository)
    )

    val uiState by homeViewModel.uiState.collectAsStateCompat()

    var selectedDestination by remember {
        mutableStateOf(VeloPayDestination.HOME)
    }

    var showSettings by remember {
        mutableStateOf(false)
    }

    VeloPayTheme {
        Scaffold(
            bottomBar = {
                VeloPayBottomNavigation(
                    selectedDestination = selectedDestination,
                    onDestinationSelected = { destination ->
                        selectedDestination = destination
                        showSettings = false
                    }
                )
            }
        ) { innerPadding ->
            when {
                showSettings -> {
                    PlaceholderScreen(
                        title = "Settings",
                        description = "VeloPay demo settings",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                selectedDestination == VeloPayDestination.HOME -> {
                    HomeScreen(
                        uiState = uiState,
                        onSettingsClick = { showSettings = true },
                        contentPadding = innerPadding
                    )
                }

                else -> {
                    PlaceholderScreen(
                        title = selectedDestination.label,
                        description = selectedDestination.title,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun PlaceholderScreen(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    androidx.compose.foundation.layout.Column(
        modifier = modifier.padding(
            horizontal = 20.dp,
            vertical = 24.dp
        )
    ) {
        androidx.compose.material3.Text(
            text = title,
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )

        androidx.compose.material3.Text(
            text = description,
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
        )

        androidx.compose.material3.Text(
            text = "DEMO MODE · SIMULATED DATA",
            style = androidx.compose.material3.MaterialTheme.typography.labelMedium
        )
    }
}
