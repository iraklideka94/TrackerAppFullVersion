package com.example.trackerapp.balance.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackerapp.core.domain.CoreRepository
import kotlinx.coroutines.launch

class BalanceViewModel(
    private val coreRepository: CoreRepository
) : ViewModel() {

    var state by mutableStateOf(BalanceState())
        private set


    init {
        viewModelScope.launch {
            state = state.copy(
                balance = coreRepository.getBalance()
            )
        }
    }

    fun onAction(action: BalanceAction) {
        when (action) {
            is BalanceAction.onBalanceChanged -> {
                state = state.copy(
                    balance = action.newBalance
                )
            }

            BalanceAction.onBalanceSaved -> {
                viewModelScope.launch {
                    coreRepository.updateBalance(state.balance)

                }
            }
        }
    }
}