package com.iheke.republicservices.presentation.di

import com.iheke.republicservices.presentation.di.viewmodel.ViewModelSubComponent

/**
Interface for creating a subcomponent that provides dependencies scoped to the lifetime of a ViewModel.
 */
interface Injector {

    /**
    Creates a subcomponent that provides dependencies for a ViewModel.
    @return A [ViewModelSubComponent] instance for injecting dependencies into a ViewModel.
     */
    fun createViewModelSubComponent(): ViewModelSubComponent
}