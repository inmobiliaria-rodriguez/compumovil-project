package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginFunctions(
    //auth: FirebaseAuth,
    //user: FirebaseUser?
) {
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null

    fun getAuth():  FirebaseAuth {
        return auth
    }
    fun getUser():  FirebaseUser? {
        return user
    }
    fun setAuth(authIn:FirebaseAuth){
        auth = authIn
    }
    fun setUser(userIn:FirebaseUser){
        user = userIn
    }

    fun createNewUser(
        context: Context,
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

