package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference


class LoginFunctions() {
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null
    private val database = DatabaseFunctions()

    fun getAuth():  FirebaseAuth {
        return auth
    }
    fun getUser():  FirebaseUser? {
        return user
    }
    fun setAuth(authIn:FirebaseAuth){
        auth = authIn
    }
    fun setDatabase(dbIn: DatabaseReference){
        database.setDatabase(dbIn)
    }
    fun setUser(userIn:FirebaseUser){
        user = userIn
    }

    fun createNewUser(
        context: Context,
        userObj: User,
        email:String,
        password: String,
        onSuccessRegister: () -> Unit,
    ){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                    user = auth.currentUser
                    var userId : String = ""
                    user?.let {
                        userId = it.uid
                    }
                    database.writeNewUser(userId,userObj)
                    onSuccessRegister()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    //OnRegisterFail
                }
            }
    }

    fun logInToTheApp(
        context: Context,
        email:String,
        password: String,
        onSuccessLogin: () -> Unit,
    ){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    onSuccessLogin()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    //OnFailLogin
                }
            }
    }
}

