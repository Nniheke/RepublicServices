package com.iheke.republicservices.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iheke.republicservices.presentation.driver.DriverViewModel
import com.iheke.republicservices.presentation.route.RouteViewModel

/**
Composable function that represents the main screen of the app.

This screen contains a navigation host that handles two destinations:

the driver list screen and the route screen for a selected driver.

@param viewModel The instance of [DriverViewModel] used to provide data to the driver list screen.

@param routeViewModel The instance of [RouteViewModel] used to provide data to the route screen.
 */

@Composable
fun MainScreen(viewModel: DriverViewModel, routeViewModel: RouteViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "startDestination"
    ) {
        composable("startDestination") {
            DriverListScreen(viewModel,navController)
        }
        composable("routeDestination/{driverId}") { backStackEntry ->
            backStackEntry.arguments?.getString("driverId")?.toInt()?.let {
                RouteScreen(
                    it,
                    routeViewModel
                )
            }
        }
    }
}
