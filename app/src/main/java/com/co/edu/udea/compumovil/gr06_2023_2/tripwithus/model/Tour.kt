package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model

import androidx.compose.runtime.Immutable

@Immutable
data class Tour(
    val company: String,
    val name: String,
    val guide: String,
    val hour: String,
    val date: String,
    val price: String,
    val capacity: String,
    val description: String,
    val coordinates: String,
    val state: String
)