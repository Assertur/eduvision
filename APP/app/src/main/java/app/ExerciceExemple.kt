package app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import common.ExerciceLayout
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel

@Composable
fun ExerciceExemple(
    navController: NavHostController,
    menuDeroulantViewModel: MenuDeroulantViewModel
) {
    ExerciceLayout(
        hasResults = true, // Passe true si des résultats sont disponibles
        progress = 0.75f, // Progrès en pourcentage (entre 0 et 1)
        onStartClicked = {
            // Action pour "Démarrer l'exercice"
        },
        onSeeMoreClicked = {
            // Action pour "Voir plus"
        }
    )
}
