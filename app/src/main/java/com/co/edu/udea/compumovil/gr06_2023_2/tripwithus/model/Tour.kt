package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model

import androidx.compose.runtime.Immutable

@Immutable
data class Tour(
    val id: String?=null,
    val companyId: String?=null,
    val company: String?=null,
    val name: String?=null,
    val guide: String?=null,
    val hour: String?=null,
    val date: String?=null,
    val price: String?=null,
    val capacity: String?=null,
    val description: String?=null,
    val coordinates: String?=null,
    val state: String?=null
)