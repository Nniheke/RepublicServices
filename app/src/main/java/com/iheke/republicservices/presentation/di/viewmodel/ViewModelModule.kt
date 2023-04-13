package com.iheke.republicservices.presentation.di.viewmodel

import com.iheke.republicservices.domain.usecase.*
import com.iheke.republicservices.presentation.driver.DriverViewModelFactory
import com.iheke.republicservices.presentation.route.RouteViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Dagger module for providing dependencies related to viewModels.
 */
@Module
class ViewModelModule {

    /**
     * Provides a [DriverViewModelFactory] instance with dependencies injected.
     *
     * @param getRepublicServicesDataUseCase use case for getting Republic Services data
     * @param saveRepublicServicesDataUseCase use case for saving Republic Services data
     * @return a [DriverViewModelFactory] instance
     */

    @ViewModelScope
    @Provides
    fun provideDriverViewModelFactory(
        getRepublicServicesDataUseCase: GetRepublicServicesDataUseCase,
        saveRepublicServicesDataUseCase: SaveRepublicServicesDataUseCase
    ): DriverViewModelFactory {
        return DriverViewModelFactory(
            getRepublicServicesDataUseCase,
            saveRepublicServicesDataUseCase
        )
    }

    /**
     * Provides a [RouteViewModelFactory] instance with dependencies injected.
     *
     * @param getRepublicServicesDataUseCase use case for getting Republic Services data
     * @return a [RouteViewModelFactory] instance
     */
    @ViewModelScope
    @Provides
    fun provideRouteViewModelFactory(
        getRepublicServicesDataUseCase: GetRepublicServicesDataUseCase
    ): RouteViewModelFactory {
        return RouteViewModelFactory(
            getRepublicServicesDataUseCase
        )
    }
}