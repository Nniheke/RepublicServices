package com.iheke.republicservices.presentation

import android.app.Application
import com.iheke.republicservices.BuildConfig
import com.iheke.republicservices.presentation.di.Injector
import com.iheke.republicservices.presentation.di.core.*
import com.iheke.republicservices.presentation.di.viewmodel.ViewModelSubComponent

/**
 * The main application class which implements [Injector] interface to provide dependency injection.
 */
class App : Application(), Injector {

    /**
     * The [AppComponent] instance that holds the app level dependencies.
     */
    private lateinit var appComponent: AppComponent

    /**
     * Called when the application is starting.
     * Initializes the [AppComponent] with necessary dependencies.
     */
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    /**
     * Returns a new instance of [ViewModelSubComponent] from the [AppComponent].
     *
     * @return A new instance of [ViewModelSubComponent].
     */
    override fun createViewModelSubComponent(): ViewModelSubComponent {
        return appComponent.viewModelSubComponent().create()
    }
}