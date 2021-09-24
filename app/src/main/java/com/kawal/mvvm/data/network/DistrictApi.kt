package com.kawal.mvvm.data.network

import com.kawal.mvvm.BuildConfig
import com.kawal.mvvm.data.model.District
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface DistrictApi {
    @GET(BuildConfig.PREFIX + BuildConfig.DISTRICT_API)
    fun getDistricts(@QueryMap map: Map<String, Any>): Deferred<List<District>>

    @POST(BuildConfig.PREFIX + BuildConfig.DISTRICT_API)
    fun postDistrict(@Body district: District)
}