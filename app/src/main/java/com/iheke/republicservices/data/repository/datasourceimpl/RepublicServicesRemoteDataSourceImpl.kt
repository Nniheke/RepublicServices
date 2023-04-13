package com.iheke.republicservices.data.repository.datasourceimpl

import com.iheke.republicservices.data.api.RepublicServicesService
import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.data.repository.datasource.RepublicServicesRemoteDataSource
import retrofit2.Response

/**
 * Implementation of [RepublicServicesRemoteDataSource] that retrieves data from the Republic Services API
 * using [republicServicesService] to make network calls.
 */
class RepublicServicesRemoteDataSourceImpl(private val republicServicesService: RepublicServicesService) :
    RepublicServicesRemoteDataSource {

    /**
     * Retrieves Republic Services data from the API.
     *
     * @return a [Response] object containing the [RepublicServicesData] retrieved from the API.
     */
    override suspend fun getRepublicServicesData(): Response<RepublicServicesData> {
        return republicServicesService.getRepublicServicesData()
    }

}