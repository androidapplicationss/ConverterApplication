package com.sample.converterapp.model

data class Conversion(
    val id: Int,
    val description : String,
    val convertFrom : String,
    val convertTo : String,
    val multiplyBy: Double
)