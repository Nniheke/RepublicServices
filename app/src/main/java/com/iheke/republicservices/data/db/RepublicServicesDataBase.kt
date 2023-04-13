package com.iheke.republicservices.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iheke.republicservices.data.model.RepublicServicesData

/**
Room Database class for Republic Services data.

@property republicServicesDAO The [RepublicServicesDAO] instance to access the database.
 */
@Database(entities = [RepublicServicesData::class], version = 1)
abstract class RepublicServicesDataBase : RoomDatabase() {
    abstract fun republicServicesDAO() : RepublicServicesDAO
}