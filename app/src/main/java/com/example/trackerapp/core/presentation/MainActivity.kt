package com.example.trackerapp.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trackerapp.balance.presentation.BalanceScreenCore
import com.example.trackerapp.core.presentation.ui.theme.TrackerAppTheme
import com.example.trackerapp.core.presentation.util.Background
import com.example.trackerapp.core.presentation.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackerAppTheme {
                Navigation(modifier = Modifier.fillMaxSize())

            }
        }
    }


    @Composable
    fun Navigation(modifier: Modifier = Modifier) {

        val navController = rememberNavController()

        Background()

        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = Screen.SpendingOverview
        ) {

            composable<Screen.SpendingOverview> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Spending Overview")
                }
            }

            composable<Screen.SpendingDetails> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Spending Details")
                }
            }

            composable<Screen.Balance> {

            }

        }

    }

}

