package app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import common.ExerciceLayout
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import common.connexion.ConnexionViewModel

@Composable
fun ExerciceExemple(
    navController: NavHostController,
    menuDeroulantViewModel: MenuDeroulantViewModel,
    connexionViewModel: ConnexionViewModel
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
    MenuDeroulant(
        navController,
        menuDeroulantViewModel,
        onDismissRequest = { menuDeroulantViewModel.closeMenu() },
        connexionViewModel
    )
}
