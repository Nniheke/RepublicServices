package com.iheke.republicservices.domain.usecase

import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.domain.repository.RepublicServicesRepository
import kotlinx.coroutines.flow.Flow

/**
Use case that retrieves the Republic Services data from the repository.
@property republicServicesRepository the repository that provides the data.
 */
class GetRepublicServicesDataUseCase(private val republicServicesRepository: RepublicServicesRepository) {
    /**
    Executes the use case to retrieve the Republic Services data.
    @return a flow of RepublicServicesData objects.
     */
    suspend fun execute(): Flow<RepublicServicesData> =
        republicServicesRepository.getRepublicServicesData()
}