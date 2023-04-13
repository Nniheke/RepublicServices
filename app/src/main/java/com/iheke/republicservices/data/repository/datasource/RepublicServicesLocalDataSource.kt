package com.iheke.republicservices.data.repository.datasource

import com.iheke.republicservices.data.model.RepublicServicesData

/**
Interface defining the methods for accessing and modifying the Republic Services data stored in a local database.
*/
interface RepublicServicesLocalDataSource {
    suspend fun getRepublicServicesDataFromDB(): RepublicServicesData
    suspend fun saveRepublicanServicesDataToDB(republicServicesData: RepublicServicesData)
}