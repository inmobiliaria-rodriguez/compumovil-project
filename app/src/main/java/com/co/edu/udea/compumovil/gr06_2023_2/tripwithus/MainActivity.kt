package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.agency.ListOfMyTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.login.LoginPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.newtour.NewTourPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.register.RegisterPage
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.ListOfTours
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.pages.user.MapsRoute
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.theme.TripWithUsTheme

enum class TripWithUsScreen() {
    Login,
    Register,
    AgencyTours,
    NewTour,
    UserTours,
    MapTour
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        onLoginButtonClicked = {
                            navController.navigate(TripWithUsScreen.AgencyTours.name)//Goes to the Agency Dashboard
                            //navController.navigate(TripWithUsScreen.UserTours.name)//Goes to the User Dashboard
                        },
                        onRegisterButtonClicked = {
                            navController.navigate(TripWithUsScreen.Register.name)
                        }
                    )
                }
                composable(route = TripWithUsScreen.Register.name) {
                    RegisterPage(
                        onBackButtonClicked = {
                            navController.navigate(TripWithUsScreen.Login.name)
                        },
                        onRegisterButtonClicked = {
                            navController.navigate(TripWithUsScreen.UserTours.name)
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