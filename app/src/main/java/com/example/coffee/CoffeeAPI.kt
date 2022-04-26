package com.example.coffee

import retrofit2.Call
import retrofit2.http.GET

interface CoffeeAPI {

//till en början och dom två dagarna (måndag och tisdag) hade jag bara skrivit random och inte /random.json
    @GET("/random.json")
    fun getResult(): Call<Coffee> //call object from Result2klassen

}