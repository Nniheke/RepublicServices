package com.iheke.republicservices.domain.usecase

import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.domain.repository.RepublicServicesRepository

/**
A use case class responsible for saving Republic Services data to the repository.
@property republicServicesRepository The repository to save the data to.
 */
class SaveRepublicServicesDataUseCase(private val republicServicesRepository: RepublicServicesRepository) {
    /**
    Executes the use case to save the provided [republicServicesData] to the repository.
    @param republicServicesData The data to be saved to the repository.
     */
    suspend fun execute(republicServicesData: RepublicServicesData) =
        republicServicesRepository.saveRepublicServicesData(republicServicesData)
}