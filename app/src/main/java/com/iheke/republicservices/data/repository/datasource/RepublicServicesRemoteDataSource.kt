package com.iheke.republicservices.data.repository.datasource

import com.iheke.republicservices.data.model.RepublicServicesData
import retrofit2.Response

/**
Interface defining the method for accessing the Republic Services data from a remote data source.
*/
interface RepublicServicesRemoteDataSource {
    suspend fun getRepublicServicesData(): Response<RepublicServicesData>

}