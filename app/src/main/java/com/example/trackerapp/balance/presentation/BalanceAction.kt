package com.example.trackerapp.balance.presentation

sealed interface BalanceAction {
    data class onBalanceChanged(val newBalance: Double) : BalanceAction
    data object onBalanceSaved : BalanceAction

}