package com.iheke.republicservices.data.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iheke.republicservices.data.model.drivers.Driver

/**
TypeConverter class for converting between a list of [Driver] objects and a JSON string.
 */
class DriverListTypeConverter {
    /**
    Converts a list of [Driver] objects to a JSON string.
    @param drivers The list of [Driver] objects to be converted.
    @return A JSON string representation of the list of [Driver] objects.
     */

    @TypeConverter
    fun fromDriverList(drivers: List<Driver>): String {
        val gson = Gson()
        return gson.toJson(drivers)
    }

    /**
    Converts a JSON string to a list of [Driver] objects.
    @param driversJson The JSON string to be converted.
    @return A list of [Driver] objects represented by the JSON string.
     */
    @TypeConverter
    fun toDriverList(driversJson: String): List<Driver> {
        val gson = Gson()
        val type = object : TypeToken<List<Driver>>() {}.type
        return gson.fromJson(driversJson, type)
    }
}
