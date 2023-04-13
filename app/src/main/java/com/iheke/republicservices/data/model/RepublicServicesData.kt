package com.iheke.republicservices.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.iheke.republicservices.data.model.converters.DriverListTypeConverter
import com.iheke.republicservices.data.model.converters.RouteListTypeConverter
import com.iheke.republicservices.data.model.drivers.Driver
import com.iheke.republicservices.data.model.routes.Route

/**
Entity class representing Republic Services data.
@property id The ID of the Republic Services data.
@property drivers The list of drivers for Republic Services.
@property routes The list of routes for Republic Services.
 */
@Entity(tableName = "republic_services_data")
@TypeConverters(DriverListTypeConverter::class, RouteListTypeConverter::class)
data class RepublicServicesData(
    @PrimaryKey
    val id: Int,
    @SerializedName("drivers")
    var drivers: List<Driver>,
    @SerializedName("routes")
    var routes: List<Route>
)
