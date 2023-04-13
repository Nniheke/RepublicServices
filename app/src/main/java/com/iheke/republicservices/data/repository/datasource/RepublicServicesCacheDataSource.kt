package com.iheke.republicservices.data.repository.datasource

import com.iheke.republicservices.data.model.RepublicServicesData

/**
Interface defining the methods for accessing and modifying the Republic Services data cache.
*/
interface RepublicServicesCacheDataSource {
    suspend fun getRepublicServicesDataFromCache(): RepublicServicesData?
    suspend fun saveRepublicanServicesDataToCache(republicServicesData: RepublicServicesData)
}