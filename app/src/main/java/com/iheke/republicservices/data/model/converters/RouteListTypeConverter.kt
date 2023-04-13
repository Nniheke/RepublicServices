package com.iheke.republicservices.data.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iheke.republicservices.data.model.routes.Route

/**
TypeConverter class for converting between a list of [Route] objects and a JSON string.
 */
class RouteListTypeConverter {

    /**
    Converts a list of [Route] objects to a JSON string.
    @param routes The list of [Route] objects to be converted.
    @return A JSON string representation of the list of [Route] objects.
     */
    @TypeConverter
    fun fromRouteList(routes: List<Route>): String {
        val gson = Gson()
        return gson.toJson(routes)
    }

    /**
    Converts a JSON string to a list of [Route] objects.
    @param routesJson The JSON string to be converted.
    @return A list of [Route] objects represented by the JSON string.
     */
    @TypeConverter
    fun toRouteList(routesJson: String): List<Route> {
        val gson = Gson()
        val type = object : TypeToken<List<Route>>() {}.type
        return gson.fromJson(routesJson, type)
    }
}