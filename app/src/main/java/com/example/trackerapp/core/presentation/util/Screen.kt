package com.example.trackerapp.core.presentation.util

sealed interface Screen {

    @kotlinx.serialization.Serializable
    data object SpendingOverview : Screen

    @kotlinx.serialization.Serializable
    data object SpendingDetails : Screen

    @kotlinx.serialization.Serializable
    data object Balance : Screen
}