package com.iheke.republicservices.presentation.di.core

import com.iheke.republicservices.presentation.di.viewmodel.ViewModelSubComponent
import dagger.Component
import javax.inject.Singleton

/**
Dagger component interface that defines the dependencies for the application.
@property viewModelSubComponent factory method to create the ViewModelSubComponent
@see AppModule
@see NetModule
@see DatabaseModule
@see CacheDataModule
@see LocalDataModule
@see RemoteDataModule
@see RepositoryModule
@see UseCaseModule
 */

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        CacheDataModule::class,
        LocalDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class

    ]

)
interface AppComponent {
    fun viewModelSubComponent(): ViewModelSubComponent.Factory
}