package com.iheke.republicservices.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.iheke.republicservices.R
import com.iheke.republicservices.presentation.driver.DriverViewModel

/**
A composable function that displays a list of drivers and provides a button to sort the list.

@param viewModel the [DriverViewModel] to be used for getting and sorting driver data.

@param navController the [NavHostController] used for navigating to another screen with driver's id as a parameter.
 */

@Composable
fun DriverListScreen(viewModel: DriverViewModel, navController: NavHostController) {
    val sortButtonClicked = rememberSaveable { mutableStateOf(false) }
    val driverListState by if (sortButtonClicked.value) {
        viewModel.sortedDriverList.observeAsState(emptyList())
    } else {
        viewModel.unSortedDriverList.observeAsState(emptyList())
    }

    Column {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    viewModel.sortDrivers()
                    sortButtonClicked.value = true
                },
                Modifier.padding(end = dimensionResource(id = R.dimen.padding_large))
            ) {
                Text(stringResource(id = R.string.sort))
            }
        }
        LazyColumn {
            items(driverListState) { driver ->
                Text(driver.name, color = Color.Black, modifier = Modifier
                    .clickable {
                        navController.navigate("routeDestination/${driver.id}")
                    }
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                )

            }
        }
    }
}