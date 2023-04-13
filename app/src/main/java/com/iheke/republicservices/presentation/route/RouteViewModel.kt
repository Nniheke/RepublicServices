package com.iheke.republicservices.presentation.route

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.iheke.republicservices.data.model.routes.Route
import com.iheke.republicservices.domain.usecase.GetRepublicServicesDataUseCase
import kotlinx.coroutines.flow.first

/**

ViewModel class that provides the routes for a specific driver. It retrieves the list of routes

from the [getRepublicServicesDataUseCase], finds the route corresponding to the given [driverId]

and emits it as a [LiveData] object. If no route is found, it attempts to find a route of a

specific type based on the [driverId].

@property getRepublicServicesDataUseCase Use case that retrieves the list of routes.
 */

class RouteViewModel(private val getRepublicServicesDataUseCase: GetRepublicServicesDataUseCase) :
    ViewModel() {

    /**
    Returns a [LiveData] object containing the route for the given [driverId].
    @param driverId ID of the driver for which to retrieve the route.
    @return [LiveData] object containing the route.
     */
    fun getRoutes(driverId: Int) = liveData {
        val routeLiveData = MutableLiveData<Route?>()
        val routeList = getRepublicServicesDataUseCase.execute()
        val driverRoute = routeList.first().routes.find { it.id == driverId }
        if (driverRoute != null) {
            routeLiveData.postValue(driverRoute)
        } else if (driverId % 2 == 0) {
            val typeR = routeList.first().routes.find { it.type == "R" }
            routeLiveData.postValue(typeR)
        } else if (driverId % 5 == 0) {
            val typeC = routeList.first().routes.dropWhile { it.type != "C" }
                .drop(1)
                .find { it.type == "C" }
            routeLiveData.postValue(typeC)
        } else {
            val typeI = routeList.first().routes.findLast { it.type == "I" }
            routeLiveData.postValue(typeI)
        }
        emit(routeLiveData)
    }
}
