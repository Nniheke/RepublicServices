package com.iheke.republicservices.presentation.driver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iheke.republicservices.domain.usecase.*

/**
Factory class responsible for creating instances of [DriverViewModel] with the required dependencies injected through constructor.

@property getRepublicServicesDataUseCase instance of [GetRepublicServicesDataUseCase]

@property saveRepublicServicesDataUseCase instance of [SaveRepublicServicesDataUseCase]

 */
class DriverViewModelFactory(
    private val getRepublicServicesDataUseCase: GetRepublicServicesDataUseCase,
    private val saveRepublicServicesDataUseCase: SaveRepublicServicesDataUseCase
) : ViewModelProvider.Factory {

    /**
    Creates an instance of [DriverViewModel] with the provided dependencies injected through constructor.
    @param modelClass the [Class] of the [ViewModel] to be created.
    @return a new instance of [DriverViewModel] with the required dependencies injected through constructor.
     */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DriverViewModel(
            getRepublicServicesDataUseCase,
            saveRepublicServicesDataUseCase
        ) as T
    }
}