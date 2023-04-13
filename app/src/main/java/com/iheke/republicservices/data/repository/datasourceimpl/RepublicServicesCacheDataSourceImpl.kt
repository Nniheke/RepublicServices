package com.iheke.republicservices.data.repository.datasourceimpl

import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.data.repository.datasource.RepublicServicesCacheDataSource

/**
Implementation of [RepublicServicesCacheDataSource] interface that caches the Republic Services data in memory.
 */
class RepublicServicesCacheDataSourceImpl : RepublicServicesCacheDataSource {
    private lateinit var republicServicesCachedData : RepublicServicesData

    /**
    Retrieves the cached [RepublicServicesData] from memory.
    @return the cached [RepublicServicesData], or null if there is no cached data.
     */
    override suspend fun getRepublicServicesDataFromCache(): RepublicServicesData? {
        return  republicServicesCachedData
    }
    /**
    Saves [republicServicesData] to memory as the cached [RepublicServicesData].
    @param republicServicesData the [RepublicServicesData] to be saved as the cached data.
     */
    override suspend fun saveRepublicanServicesDataToCache(republicServicesData: RepublicServicesData) {
        republicServicesCachedData = republicServicesData
    }
}
