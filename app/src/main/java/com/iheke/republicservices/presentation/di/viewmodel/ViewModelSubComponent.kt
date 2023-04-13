package com.iheke.republicservices.presentation.di.viewmodel

import com.iheke.republicservices.presentation.MainActivity
import dagger.Subcomponent

/**
 * A Dagger subcomponent interface for the driver feature scope.
 *
 * This subcomponent is responsible for injecting dependencies into the classes related to the viewModel.
 *
 * @see ViewModelModule
 * @see MainActivity
 */
@ViewModelScope
@Subcomponent(modules = [ViewModelModule::class])
interface ViewModelSubComponent {
    fun inject(mainActivity: MainActivity)
    @Subcomponent.Factory
    interface Factory{
        fun create(): ViewModelSubComponent
    }
}