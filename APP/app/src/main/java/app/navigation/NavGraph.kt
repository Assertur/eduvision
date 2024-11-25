package app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.ExerciceExemple
import app.MainActivity
import home.MainContentConnected
import home.MainScreen

const val HOME_ROUTE = "home"
const val EXERCICE_EXEMPLE_ROUTE = "exercice_exemple"

/**
 * Fonction qui permet de gérer les routes de l'application.
 */
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        composable(route = HOME_ROUTE) {
            MainScreen(navController = navController)
        }
        composable(route = EXERCICE_EXEMPLE_ROUTE) {
            ExerciceExemple()
        }
    }
}
