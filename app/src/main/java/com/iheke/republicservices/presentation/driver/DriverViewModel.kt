package com.iheke.republicservices.presentation.driver

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.iheke.republicservices.data.model.RepublicServicesData
import com.iheke.republicservices.data.model.drivers.Driver
import com.iheke.republicservices.domain.usecase.GetRepublicServicesDataUseCase
import com.iheke.republicservices.domain.usecase.SaveRepublicServicesDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
ViewModel responsible for providing data and managing the state of the Driver screen.

@property getRepublicServicesDataUseCase use case for retrieving Republic Services data from the repository

@property saveRepublicServicesDataUseCase use case for saving Republic Services data to the repository

 */
class DriverViewModel(
    private val getRepublicServicesDataUseCase: GetRepublicServicesDataUseCase,
    private val saveRepublicServicesDataUseCase: SaveRepublicServicesDataUseCase
) : ViewModel() {

    private val _unSortedDriverList = MutableLiveData<List<Driver>>()
    val unSortedDriverList: LiveData<List<Driver>> = _unSortedDriverList

    private val _sortedDriverList = MutableLiveData<List<Driver>>()
    val sortedDriverList: LiveData<List<Driver>> = _sortedDriverList

    /**
    Retrieve all Republic Services data from the repository as a LiveData object
    @return LiveData object containing the list of Republic Services data
     */
    fun getAllRepublicServiceData() = liveData {
        val dataList = getRepublicServicesDataUseCase.execute()
        _unSortedDriverList.value = dataList.first().drivers
        _sortedDriverList.value = unSortedDriverList.value?.sortedBy { it.name.split(" ").last() } ?: emptyList()
        emit(dataList)
    }

    /**
    Save Republic Services data to the repository using a Flow object
    @param republicServicesData Flow object containing the Republic Services data to be saved
     */
    fun saveAllRepublicServiceData(republicServicesData: Flow<RepublicServicesData>)  {
        CoroutineScope(IO).launch {
            saveRepublicServicesDataUseCase.execute(republicServicesData.first())
        }
    }

    /**
    Retrieve a sorted list of drivers from the Republic Services data as a LiveData object
    @return LiveData object containing the sorted list of drivers
     */
    fun sortDrivers() =_sortedDriverList.value

}