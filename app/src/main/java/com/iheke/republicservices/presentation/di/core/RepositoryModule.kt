package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.data.repository.RepublicServicesRepositoryImpl
import com.iheke.republicservices.data.repository.datasource.RepublicServicesCacheDataSource
import com.iheke.republicservices.data.repository.datasource.RepublicServicesLocalDataSource
import com.iheke.republicservices.data.repository.datasource.RepublicServicesRemoteDataSource
import com.iheke.republicservices.domain.repository.RepublicServicesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Dagger module responsible for providing the [RepublicServicesRepository] instance.
 */
@Module
class RepositoryModule {
    /**
     * Provides a singleton instance of the [RepublicServicesRepository] interface, which serves as the data access layer
     * of the application. It depends on the [RepublicServicesRemoteDataSource], [RepublicServicesLocalDataSource], and
     * [RepublicServicesCacheDataSource] interfaces to retrieve data from remote, local, and cached sources.
     */

    @Singleton
    @Provides
    fun provideRepublicServicesRepository(
        republicServicesRemoteDataSource: RepublicServicesRemoteDataSource,
        republicServicesLocalDataSource: RepublicServicesLocalDataSource,
        republicServicesCacheDataSource: RepublicServicesCacheDataSource
    ): RepublicServicesRepository {

        return RepublicServicesRepositoryImpl(
            republicServicesRemoteDataSource,
            republicServicesLocalDataSource,
            republicServicesCacheDataSource
        )
    }

}