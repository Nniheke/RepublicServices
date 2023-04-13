package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.data.db.RepublicServicesDAO
import com.iheke.republicservices.data.repository.datasource.RepublicServicesLocalDataSource
import com.iheke.republicservices.data.repository.datasourceimpl.RepublicServicesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Dagger module that provides a [RepublicServicesLocalDataSource] instance for the app's local data source.
 */
@Module
class LocalDataModule {
    /**
    Provides a [RepublicServicesLocalDataSource] instance.
    @param republicServicesDao The DAO for accessing the local database.
    @return A [RepublicServicesLocalDataSource] instance.
     */
    @Singleton
    @Provides
    fun provideRepublicServicesLocalDataSource(republicServicesDao: RepublicServicesDAO) : RepublicServicesLocalDataSource {
        return RepublicServicesLocalDataSourceImpl(republicServicesDao)
    }

}