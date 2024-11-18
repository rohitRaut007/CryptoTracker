package com.plcoding.cryptotracker.crypto.presentation.coin_list

import com.plcoding.cryptotracker.crypto.presentation.CoinUi

sealed interface CoinListAction {
    data class onCoinClick(val coinUi: CoinUi) : CoinListAction
    data object onRefresh : CoinListAction
}