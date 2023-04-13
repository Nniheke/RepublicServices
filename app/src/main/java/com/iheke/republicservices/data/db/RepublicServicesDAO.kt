package com.iheke.republicservices.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iheke.republicservices.data.model.RepublicServicesData

/**
Data Access Object (DAO) for Republic Services data.
 */
@Dao
interface RepublicServicesDAO {
    /**
    Saves all Republic Services data to the local database.
    If the data already exists in the database, it will be replaced.
    @param data The [RepublicServicesData] object to be saved.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllRepublicServicesData(data: RepublicServicesData)
    /**
    Retrieves all saved Republic Services data from the local database.
    @return A [RepublicServicesData] object containing all saved data.
     */
    @Query("SELECT * FROM republic_services_data")
    suspend fun getAllRepublicServicesData() : RepublicServicesData

}