
package com.volbasty.velopay.core.design

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val VeloPayDarkColorScheme = darkColorScheme(
    primary = VeloPayElectricBlue,
    onPrimary = VeloPayWhite,
    background = VeloPayInk,
    onBackground = VeloPayWhite,
    surface = VeloPayPanel,
    onSurface = VeloPayWhite,
    surfaceVariant = VeloPayPanel,
    onSurfaceVariant = VeloPayMutedText
)

@Composable
fun VeloPayTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = VeloPayDarkColorScheme,
        typography = VeloPayTypography,
        content = content
    )
}
