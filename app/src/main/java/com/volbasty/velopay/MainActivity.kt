
package com.volbasty.velopay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF0B1020)
private val Panel = Color(0xFF151D31)
private val ElectricBlue = Color(0xFF5B8CFF)
private val MutedText = Color(0xFFA8B3C9)
private val White = Color(0xFFF5F7FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                VeloPayApp()
            }
        }
    }
}

@Composable
private fun VeloPayApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Ink,
        contentColor = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "VeloPay",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = White
            )

            Text(
                text = "Created by Volbasty Studios",
                fontSize = 13.sp,
                color = MutedText
            )

            Text(
                text = "DEMO MODE · SIMULATED DATA",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Panel,
                        RoundedCornerShape(12.dp)
                    )
                    .padding(14.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = ElectricBlue
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Panel,
                        RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Your financial overview",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Your demo financial workspace",
                    fontSize = 14.sp,
                    color = MutedText
                )

                Text(
                    text = "Sample figures will appear here",
                    fontSize = 15.sp,
                    color = ElectricBlue
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Your financial life, connected.",
                    fontSize = 15.sp,
                    color = MutedText
                )
            }
        }
    }
}
