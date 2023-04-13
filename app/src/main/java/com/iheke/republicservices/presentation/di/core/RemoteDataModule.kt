package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.data.api.RepublicServicesService
import com.iheke.republicservices.data.repository.datasource.RepublicServicesRemoteDataSource
import com.iheke.republicservices.data.repository.datasourceimpl.RepublicServicesRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Dagger module that provides dependencies for remote data sources in the application.
 */
@Module
class RemoteDataModule(){
    /**
    Provides the [RepublicServicesRemoteDataSource] implementation by injecting the [RepublicServicesService] instance
    obtained from the [NetModule].
    @param republicServicesService The [RepublicServicesService] instance used to create the [RepublicServicesRemoteDataSource].
    @return A [RepublicServicesRemoteDataSource] instance.
     */

    @Singleton
    @Provides
    fun provideRepublicServicesRemoteDataSource(republicServicesService: RepublicServicesService) : RepublicServicesRemoteDataSource {
        return RepublicServicesRemoteDataSourceImpl(republicServicesService)
    }
}