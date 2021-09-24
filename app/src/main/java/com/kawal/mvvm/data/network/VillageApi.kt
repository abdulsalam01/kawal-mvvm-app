package com.kawal.mvvm.data.network

import com.kawal.mvvm.BuildConfig
import com.kawal.mvvm.data.model.Village
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface VillageApi {
    @GET(BuildConfig.PREFIX + BuildConfig.VILLAGE_API)
    fun getVillage(@QueryMap() map: Map<String, String>): Deferred<List<Village>>

    @POST(BuildConfig.PREFIX + BuildConfig.VILLAGE_API)
    fun postVillage(@Body village: Village)
}