package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.domain.repository.RepublicServicesRepository
import com.iheke.republicservices.domain.usecase.*
import dagger.Module
import dagger.Provides
/**
Dagger module providing dependencies for all use cases.
 */
@Module
class UseCaseModule {

    /**
    Provides the GetRepublicServicesDataUseCase use case.
    @param republicServicesRepository The repository that provides access to the data.
    @return The GetRepublicServicesDataUseCase use case.
     */
    @Provides
    fun provideGetRepublicServicesDataUseCase(republicServicesRepository: RepublicServicesRepository): GetRepublicServicesDataUseCase {
        return GetRepublicServicesDataUseCase(republicServicesRepository)
    }

    /**
    Provides the SaveRepublicServicesDataUseCase use case.
    @param republicServicesRepository The repository that provides access to the data.
    @return The SaveRepublicServicesDataUseCase use case.
     */
    @Provides
    fun provideSaveRepublicServicesDataUseCase(republicServicesRepository: RepublicServicesRepository): SaveRepublicServicesDataUseCase {
        return SaveRepublicServicesDataUseCase(republicServicesRepository)
    }

}