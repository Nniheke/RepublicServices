package com.iheke.republicservices.data.repository

import android.util.Log
import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.data.repository.datasource.RepublicServicesCacheDataSource
import com.iheke.republicservices.data.repository.datasource.RepublicServicesLocalDataSource
import com.iheke.republicservices.data.repository.datasource.RepublicServicesRemoteDataSource
import com.iheke.republicservices.domain.repository.RepublicServicesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

/**
 * Implementation of [RepublicServicesRepository] interface. Acts as a single source of truth for
 * retrieving and storing [RepublicServicesData]. The repository fetches the data from the local
 * database and/or network, and saves the data to the local database and/or cache as needed.
 *
 * @property republicServicesRemoteDataSource data source for fetching data from network
 * @property republicServicesLocalDataSource data source for fetching and saving data to the local database
 * @property republicServicesCacheDataSource data source for fetching and saving data to the cache
 */
class RepublicServicesRepositoryImpl(
    private val republicServicesRemoteDataSource: RepublicServicesRemoteDataSource,
    private val republicServicesLocalDataSource: RepublicServicesLocalDataSource,
    private val republicServicesCacheDataSource: RepublicServicesCacheDataSource
) : RepublicServicesRepository {

    /**
     * Saves [republicServicesData] to the local database and cache.
     *
     * @param republicServicesData the [RepublicServicesData] to be saved
     */
    override suspend fun saveRepublicServicesData(republicServicesData: RepublicServicesData) {
        republicServicesLocalDataSource.saveRepublicanServicesDataToDB(republicServicesData)
        republicServicesCacheDataSource.saveRepublicanServicesDataToCache(republicServicesData)
    }

    /**
     * Retrieves [RepublicServicesData] from the cache. If the cache is empty, retrieves the data
     * from the database and saves it to the cache before returning it.
     *
     * @return a [Flow] emitting the [RepublicServicesData] from the cache or database
     */
    override suspend fun getRepublicServicesData(): Flow<RepublicServicesData> {
        return getRepublicServicesDataFromCache()
    }

    /**
     * Retrieves [RepublicServicesData] from the network. If the request fails, retrieves the data
     * from the database and saves it to the cache before returning it.
     *
     * @return a [Flow] emitting the [RepublicServicesData] from the network or database
     */
    private suspend fun getRepublicServicesDataFromApi(): Flow<RepublicServicesData> = flow {
        try {
            val response = republicServicesRemoteDataSource.getRepublicServicesData()
            val body = response.body()
            if (body != null) {
                emit(body)
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
    }

    /**
     * Retrieves [RepublicServicesData] from the local database. If the data is empty, retrieves the
     * data from the network and saves it to the database before returning it.
     *
     * @return a [Flow] emitting the [RepublicServicesData] from the database or network
     */
    private suspend fun getRepublicServicesDataFromDB(): Flow<RepublicServicesData> = flow {
        val data = republicServicesLocalDataSource.getRepublicServicesDataFromDB()
        if (data.drivers.isNotEmpty() && data.routes.isNotEmpty()) {
            emit(data)
        } else {
            Log.e(TAG, "Failed to retrieve data form DB")
        }
    }.catch { exception ->
        val data = getRepublicServicesDataFromApi()
        republicServicesLocalDataSource.saveRepublicanServicesDataToDB(data.first())
        emit(data.first())
    }

    /**
    Retrieves the RepublicServicesData from cache data source, and emits it as a Flow.
    If the data is not available in the cache data source, it tries to retrieve it from the
    local data source. If the local data source also does not have the data, it tries to
    retrieve it from the remote data source and saves it to the cache and local data sources
    for future use.
    @return a Flow of RepublicServicesData.
     */
    private suspend fun getRepublicServicesDataFromCache(): Flow<RepublicServicesData> = flow {
        val data = republicServicesCacheDataSource.getRepublicServicesDataFromCache()
        if (data != null) {
            emit(data)
        } else {
            Log.e(TAG, "Failed to retrieve data form Cache")
        }
    }.catch { exception ->
        val data = getRepublicServicesDataFromDB()
        republicServicesCacheDataSource.saveRepublicanServicesDataToCache(data.first())
        emit(data.first())
    }

companion object{
    val TAG = RepublicServicesRepositoryImpl::class.java.simpleName
}
}