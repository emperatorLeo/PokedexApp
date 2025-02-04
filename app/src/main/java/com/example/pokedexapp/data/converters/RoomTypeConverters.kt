package com.example.pokedexapp.data.converters

import androidx.room.TypeConverter
import com.example.pokedexapp.data.model.entities.MovementList
import com.example.pokedexapp.data.model.entities.TypeList
import com.google.gson.Gson

class RoomTypeConverters {
    @TypeConverter
    fun convertMovementListToJson(movementList: MovementList): String = Gson().toJson(movementList)

    @TypeConverter
    fun convertJsonToMovementList(jsonString: String): MovementList =
        Gson().fromJson(jsonString, MovementList::class.java)

    @TypeConverter
    fun convertFromListToJson(list: TypeList): String = Gson().toJson(list)

    @TypeConverter
    fun convertFromJsonToList(jsonString: String): TypeList = Gson().fromJson(
        jsonString,
        TypeList::class.java
    )
}