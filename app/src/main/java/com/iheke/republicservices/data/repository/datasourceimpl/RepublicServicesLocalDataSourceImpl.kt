package com.iheke.republicservices.data.repository.datasourceimpl

import com.iheke.republicservices.data.db.RepublicServicesDAO
import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.data.repository.datasource.RepublicServicesLocalDataSource

/**
 * Implementation of the [RepublicServicesLocalDataSource] interface for accessing local data source.
 * @param republicServicesDAO DAO interface for accessing the local database.
 */
class RepublicServicesLocalDataSourceImpl(private val republicServicesDAO: RepublicServicesDAO) :
    RepublicServicesLocalDataSource {

    /**
     * Retrieves the [RepublicServicesData] object from the local database.
     * @return [RepublicServicesData] object if it exists in the database, null otherwise.
     */

    override suspend fun getRepublicServicesDataFromDB(): RepublicServicesData {
        return republicServicesDAO.getAllRepublicServicesData()
    }

    /**
     * Saves the [RepublicServicesData] object to the local database.
     * @param republicServicesData [RepublicServicesData] object to be saved.
     */
    override suspend fun saveRepublicanServicesDataToDB(republicServicesData: RepublicServicesData) {
        republicServicesDAO.saveAllRepublicServicesData(republicServicesData)
    }


}