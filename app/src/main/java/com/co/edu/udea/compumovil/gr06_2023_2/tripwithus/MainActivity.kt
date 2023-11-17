package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.User
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.agency.ListOfMyTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.login.LoginPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.newtour.NewTourPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.register.RegisterPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.ListOfTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.MapsRoute
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.DatabaseFunctions
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils.LoginFunctions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

enum class TripWithUsScreen() {
    Login,
    Register,
    AgencyTours,
    NewTour,
    UserTours,
    MapTour
}

private val loggclass = LoginFunctions()
private val dbclass = DatabaseFunctions()
private var loggUser: User? = null

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loggclass.setAuth(Firebase.auth)
        dbclass.setDatabase(Firebase.database.reference)
        loggclass.setDatabase(dbclass.getDatabase())
        setContent {
            TripWithUsApp()
        }
    }
}



@Composable
fun TripWithUsApp(
){
    val navController = rememberNavController()
    TripWithUsTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = TripWithUsTheme.colors.uiBackground) {
            NavHost(
                navController = navController,
                startDestination = TripWithUsScreen.Login.name,
                //modifier = modifier.padding(innerPadding)
            ) {
                composable(route = TripWithUsScreen.Login.name) {
                    LoginPage(
                        loggObj = loggclass,
                        onSuccessLogin = {
                            var user =loggclass.getAuth().currentUser
                            var userId : String = ""
                            user?.let {
                                userId = it.uid
                            }
                            GlobalScope.launch (Dispatchers.Main){
                                loggUser = dbclass.getLoggedUser(userId)
                                Log.i("firebase", "Pasó al activity ${loggUser} and ${loggUser?.name}")
                                if(loggUser?.agency == true){
                                    navController.navigate(TripWithUsScreen.AgencyTours.name)
                                }else{
                                    navController.navigate(TripWithUsScreen.UserTours.name)
                                }
                            }
                        },
                        onRegisterButtonClicked = {
                            navController.navigate(TripWithUsScreen.Register.name)
                        }
                    )
                }
                composable(route = TripWithUsScreen.Register.name) {
                    RegisterPage(
                        loggObj = loggclass,
                        onBackButtonClicked = {
                            navController.navigate(TripWithUsScreen.Login.name)
                        },
                        onSuccessRegister = {
                            var user =loggclass.getAuth().currentUser
                            var userId : String = ""
                            user?.let {
                                userId = it.uid
                            }
                            GlobalScope.launch (Dispatchers.Main){
                                loggUser = dbclass.getLoggedUser(userId)
                                if(loggUser?.agency == true){
                                    navController.navigate(TripWithUsScreen.AgencyTours.name)
                                }else{
                                    navController.navigate(TripWithUsScreen.UserTours.name)
                                }
                            }
                        }
                    )
                }
                composable(route = TripWithUsScreen.AgencyTours.name) {
                    ListOfMyTours(
                        onNewTourClicked = {
                            navController.navigate(TripWithUsScreen.NewTour.name)
                        }
                    )
                }
                composable(route = TripWithUsScreen.NewTour.name) {
                    NewTourPage(
                        onCreateButtonClicked = {
                            navController.navigate(TripWithUsScreen.AgencyTours.name)
                        },
                        onCancelButtonClicked = {
                            navController.navigate(TripWithUsScreen.AgencyTours.name)
                        }
                    )
                }
                composable(route = TripWithUsScreen.UserTours.name) {
                    ListOfTours(
                        onInscriptionButtonClicked = {
                            navController.navigate(TripWithUsScreen.MapTour.name)
                        }
                    )
                }
                composable(route = TripWithUsScreen.MapTour.name) {
                    MapsRoute()
                }
            }
        }
    }
}