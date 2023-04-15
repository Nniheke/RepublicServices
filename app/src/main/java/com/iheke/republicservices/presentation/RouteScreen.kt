package com.iheke.republicservices.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.iheke.republicservices.R
import com.iheke.republicservices.presentation.route.RouteViewModel

/**

A composable function that displays the route information for a specific driver.

@param driverId The ID of the driver whose route information is to be displayed.

@param viewModel The [RouteViewModel] used to fetch the route information.
 */

@Composable
fun RouteScreen(driverId: Int, viewModel: RouteViewModel) {
    val routeState by viewModel.getRoutes(driverId).observeAsState(null)

    if (routeState == null) {
        Text(stringResource(R.string.no_route, driverId))
    } else {
        Row(Modifier.padding(dimensionResource(id = R.dimen.padding_large))) {
            Text(
                stringResource(id = R.string.route_type, routeState?.value?.type.toString()),
                Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_large))
            )
            Text(stringResource(id = R.string.route_name, routeState?.value?.name.toString()))
        }
    }
}