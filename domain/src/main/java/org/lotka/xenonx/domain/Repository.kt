package org.lotka.xenonx.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.model.CoinModel

interface Repository {

    fun getCoins(): Flow<PagingData<CoinModel>>

    fun getCoinById(coinId: String): Flow<CoinModel>

}