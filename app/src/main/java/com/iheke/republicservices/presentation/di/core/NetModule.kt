package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.data.api.RepublicServicesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
Dagger module for providing networking-related dependencies.
@property baseUrl The base URL of the API.
 */
@Module
class NetModule(private val baseUrl: String) {
    /**
    Provides a [Retrofit] instance with the base URL and [GsonConverterFactory] converter factory.
    @return The [Retrofit] instance.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
    /**
    Provides an implementation of the [RepublicServicesService] interface.
    @param retrofit The [Retrofit] instance.
    @return The [RepublicServicesService] implementation.
     */
    @Singleton
    @Provides
    fun provideRepublicServicesService(retrofit: Retrofit): RepublicServicesService{
        return retrofit.create(RepublicServicesService::class.java)
    }
}