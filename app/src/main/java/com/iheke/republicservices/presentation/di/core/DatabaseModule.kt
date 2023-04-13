package com.iheke.republicservices.presentation.di.core

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.iheke.republicservices.data.db.RepublicServicesDAO
import com.iheke.republicservices.data.db.RepublicServicesDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Dagger module that provides instances of the RepublicServicesDataBase and RepublicServicesDAO classes for use
throughout the application.
 */

@Module
class DatabaseModule {

    /**
    Provides an instance of the RepublicServicesDataBase using the provided context.
    @param context The context in which the database is created.
    @return An instance of the RepublicServicesDataBase.
     */
    @Singleton
    @Provides
    fun provideRepublicServicesDataBase(context: Context): RepublicServicesDataBase {
        return Room.databaseBuilder(
            context,
            RepublicServicesDataBase::class.java,
            "RepublicServicesDataBase"
        ).build()
    }

    /**
    Provides an instance of the RepublicServicesDAO for use throughout the application.
    @param republicServicesDAO An instance of the RepublicServicesDataBase class.
    @return An instance of the RepublicServicesDAO.
     */

    @Singleton
    @Provides
    fun provideRepublicServicesDao(republicServicesDAO: RepublicServicesDataBase): RepublicServicesDAO {
        return republicServicesDAO.republicServicesDAO()
    }

}