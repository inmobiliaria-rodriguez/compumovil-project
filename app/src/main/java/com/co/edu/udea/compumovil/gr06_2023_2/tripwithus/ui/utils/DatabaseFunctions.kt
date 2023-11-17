package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils

import android.util.Log
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.getValue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.tasks.await

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

    suspend fun getLoggedUser(userId: String) :User?{
        var user:User? = User()
        val snapshot = database.child("users").child(userId).get().await()
        user = snapshot.getValue<User>()
        Log.i("firebase", "Got user ${user} and ${user?.name}")
        return user
    }
}