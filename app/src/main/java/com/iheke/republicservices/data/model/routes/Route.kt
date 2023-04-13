package com.iheke.republicservices.data.model.routes
import com.google.gson.annotations.SerializedName

/**
Data class representing a route.
@property id The ID of the route.
@property name The name of the route.
@property type The type of the route.
 */
data class Route(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)