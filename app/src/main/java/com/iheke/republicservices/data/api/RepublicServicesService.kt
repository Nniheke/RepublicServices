package com.iheke.republicservices.data.api

import com.iheke.republicservices.data.model.RepublicServicesData
import retrofit2.Response
import retrofit2.http.GET

/**
Interface for retrieving Republic Services data.
 */
interface RepublicServicesService {
    /**
    Retrieves Republic Services data via a GET request.
    @return A [Response] object containing the requested [RepublicServicesData].
     */
    @GET("data")
    suspend fun getRepublicServicesData(): Response<RepublicServicesData>
}