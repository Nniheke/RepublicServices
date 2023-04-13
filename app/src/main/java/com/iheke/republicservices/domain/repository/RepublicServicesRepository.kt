package com.iheke.republicservices.domain.repository

import com.iheke.republicservices.data.model.RepublicServicesData
import kotlinx.coroutines.flow.Flow

/**
A repository interface that defines the operations that can be performed on Republic Services data,
including saving, fetching, and sorting.
 */
interface RepublicServicesRepository {
    suspend fun saveRepublicServicesData(republicServicesData: RepublicServicesData)
    suspend fun getRepublicServicesData(): Flow<RepublicServicesData>
}