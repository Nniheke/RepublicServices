package com.iheke.republicservices.presentation.di.core

import android.content.Context
import com.iheke.republicservices.presentation.di.viewmodel.ViewModelSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
Dagger module that provides the application context.
@param context the application context to be provided
 */
@Module(subcomponents = [ViewModelSubComponent::class])
class AppModule(private val context : Context) {
    /**
    Provides the application context.
    @return the application context
     */
    @Singleton
    @Provides
    fun provideApplicationContext() : Context{
        return context.applicationContext
    }
}