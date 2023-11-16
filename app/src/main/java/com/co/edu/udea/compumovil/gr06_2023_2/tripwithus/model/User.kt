package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model

import androidx.compose.runtime.Immutable

@Immutable
data class User(
    val agency: Boolean?=null,
    val name: String?=null,
    val document: String?=null,
    val email: String?=null
)