package com.iheke.republicservices.presentation.di.viewmodel

import javax.inject.Scope

/**
This is a custom Dagger scope annotation used for the Driver feature module.
It's used to define a scope for dependencies that should have a single instance
within the ViewModel module and its sub-components.
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelScope