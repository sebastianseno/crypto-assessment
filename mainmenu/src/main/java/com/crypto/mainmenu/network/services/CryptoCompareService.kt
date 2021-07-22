package com.crypto.mainmenu.network.services

import com.crypto.mainmenu.network.entity.TopTierData
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoCompareService {

    @GET("data/top/totaltoptiervolfull")
    suspend fun getTotalTopTier(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("tsym") tsym: String,
    ): TopTierData

}