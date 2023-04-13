package com.iheke.republicservices.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.iheke.republicservices.presentation.di.Injector
import com.iheke.republicservices.presentation.driver.DriverViewModel
import com.iheke.republicservices.presentation.driver.DriverViewModelFactory
import com.iheke.republicservices.presentation.route.RouteViewModel
import com.iheke.republicservices.presentation.route.RouteViewModelFactory
import javax.inject.Inject

/**

The MainActivity class is the entry point to the application. It initializes the ViewModel objects

and observes the LiveData objects of the DriverViewModel to update the UI when data changes.

The activity uses Dagger to inject the ViewModelFactory objects.
 */

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: DriverViewModelFactory
    private lateinit var viewModel: DriverViewModel

    @Inject
    lateinit var routeFactory: RouteViewModelFactory
    private lateinit var routeViewModel: RouteViewModel

    /**
    Initializes the ViewModel objects and observes the LiveData objects of the DriverViewModel to update
    the UI when data changes. Also, sets the content view of the activity with the MainScreen Composable.
    @param savedInstanceState Bundle object containing the activity's previously saved state.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as Injector).createViewModelSubComponent()
            .inject(this)
        viewModel = ViewModelProvider(this, factory)
            .get(DriverViewModel::class.java)
        routeViewModel = ViewModelProvider(this, routeFactory)
            .get(RouteViewModel::class.java)
        viewModel.getAllRepublicServiceData().observe(this) {
            if (it != null) {
                viewModel.saveAllRepublicServiceData(it)
            }
        }
        setContent{
            MainScreen(viewModel, routeViewModel)
        }

    }

}