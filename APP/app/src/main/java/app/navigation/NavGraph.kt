package app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.ExerciceExemple
import common.bottomAppBar.MyBottomAppBar
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import home.MainScreen

const val HOME_ROUTE = "home"
const val EXERCICE_EXEMPLE_ROUTE = "exercice_exemple"

/**
 * Fonction qui permet de gérer les routes de l'application.
 */
@Composable
fun SetupNavGraph(navController: NavHostController) {
    val menuDeroulantViewModel = MenuDeroulantViewModel()

    Scaffold(bottomBar = { MyBottomAppBar(menuDeroulantViewModel) }) {
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE,
            modifier = Modifier.padding(it) // Gère le padding pour ne pas recouvrir la BottomAppBar
        ) {
            composable(route = HOME_ROUTE) {
                MainScreen(
                    navController = navController,
                    menuDeroulantViewModel = menuDeroulantViewModel
                )
            }
            composable(route = EXERCICE_EXEMPLE_ROUTE) {
                ExerciceExemple(
                    navController = navController,
                    menuDeroulantViewModel = menuDeroulantViewModel
                )
            }
        }
    }
}
