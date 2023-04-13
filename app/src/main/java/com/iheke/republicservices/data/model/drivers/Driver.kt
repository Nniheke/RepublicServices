package com.iheke.republicservices.data.model.drivers
import com.google.gson.annotations.SerializedName

/**
Data class representing a driver.
@property id The ID of the driver.
@property name The name of the driver.
 */
data class Driver(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)