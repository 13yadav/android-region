package com.strangecoder.region

import com.strangecoder.region.models.CountryItem
import retrofit2.http.GET

interface RegionApi {


    @GET("asia")
    suspend fun getCountries(): List<CountryItem>
}