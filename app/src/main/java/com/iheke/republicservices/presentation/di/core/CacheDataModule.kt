package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.data.repository.datasource.RepublicServicesCacheDataSource
import com.iheke.republicservices.data.repository.datasourceimpl.RepublicServicesCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Dagger module that provides a singleton instance of [RepublicServicesCacheDataSource] interface
using [RepublicServicesCacheDataSourceImpl] implementation for caching data.
 */
@Module
class CacheDataModule {
    /**
    Provides a singleton instance of [RepublicServicesCacheDataSource] interface using
    [RepublicServicesCacheDataSourceImpl] implementation for caching data.
     */
    @Singleton
    @Provides
    fun provideRepublicServicesCacheDataSource() : RepublicServicesCacheDataSource {
        return RepublicServicesCacheDataSourceImpl()
    }

}