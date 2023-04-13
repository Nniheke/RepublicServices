package com.iheke.republicservices.presentation.route

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iheke.republicservices.domain.usecase.GetRepublicServicesDataUseCase

/**
Factory class for creating instances of [RouteViewModel].
@param getRepublicServicesDataUseCase The use case to retrieve Republic Services data.
 */

class RouteViewModelFactory(
    private val getRepublicServicesDataUseCase: GetRepublicServicesDataUseCase,
) : ViewModelProvider.Factory {

    /**
    Creates a new instance of [RouteViewModel].
    @param modelClass The class of the [ViewModel] to be created.
    @return A new instance of [RouteViewModel].
     */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RouteViewModel(getRepublicServicesDataUseCase) as T
    }
}