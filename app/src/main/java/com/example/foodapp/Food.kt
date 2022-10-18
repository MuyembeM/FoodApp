package com.example.foodapp

import java.io.Serializable

data class Food(var id: Int, var name: String, var recipe: String) : Serializable
