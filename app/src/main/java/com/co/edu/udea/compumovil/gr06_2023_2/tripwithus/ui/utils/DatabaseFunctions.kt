package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils

import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.User
import com.google.firebase.database.DatabaseReference

class DatabaseFunctions() {
    private lateinit var database: DatabaseReference

    fun getDatabase():  DatabaseReference {
        return database
    }
    fun setDatabase(databaseIn: DatabaseReference){
        database = databaseIn
    }
    fun writeNewUser(userId: String, user:User) {
        database.child("users").child(userId).setValue(user)
    }
}