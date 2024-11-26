import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import app.Game
import app.navigation.TRAVAUX_ROUTE
import common.ExerciceLayout
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import common.connexion.ConnexionViewModel
import retrofit2.HttpException
import java.io.IOException

@Composable
fun ExerciceExemple(
    navController: NavHostController,
    menuDeroulantViewModel: MenuDeroulantViewModel,
    connexionViewModel: ConnexionViewModel,
    exo : Int
) {
    // État pour stocker la réponse
    var game by remember { mutableStateOf<Game?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    var text = "Aidez la famille des oiseaux à se nourrir et à partager leur nourriture !"

    // Charger les données depuis l'API
    LaunchedEffect(Unit) {
        try {
            Log.d("API_CALL", "Fetching game data from 192.168.2.89:8080...")
            isLoading = true
//            game = ApiService.gameApi.getGameById(1) // Appel à l'API
            if (exo == 1) {
                game = Game(id = 1, name = "Calcul oiseaux", description = text)
            }else if (exo==2){
                game = Game(id = 1, name = "Calcul pommmes", description = text)
            }
            Log.d("API_CALL", "Game fetched: $game")
        } catch (e: HttpException) {
            errorMessage = "Erreur serveur : ${e.message()}"
            Log.e("API_CALL", "Error fetching game: ${e.message}")
        } catch (e: IOException) {
            errorMessage = "Erreur réseau : ${e.message}"
            Log.e("API_CALL", "Error fetching game: ${e.message}")
        } finally {
            isLoading = false
        }
    }

    // Affichage en fonction des états
    when {
        isLoading -> {
            // Écran de chargement
            Text("Chargement...")
        }

        errorMessage != null -> {
            // Afficher une erreur
            Text(errorMessage!!)
        }

        game != null -> {
            // Afficher le composable principal avec les données récupérées

            if (exo == 1){
                ExerciceLayout(
                    hasResults = true,
                    progress = 0.75f,
                    onStartClicked = {
                        navController.navigate(TRAVAUX_ROUTE)
                    },
                    onSeeMoreClicked = {
                        navController.navigate(TRAVAUX_ROUTE)
                    },
                    navController = navController,
                    game = game!! // Passe l'objet récupéré
                )
            }else if (exo == 2){
                ExerciceLayout(
                    hasResults = false,
                    onStartClicked = {
                        navController.navigate(TRAVAUX_ROUTE)
                    },
                    onSeeMoreClicked = {
                        navController.navigate(TRAVAUX_ROUTE)
                    },
                    navController = navController,
                    game = game!! // Passe l'objet récupéré
                )
            }
        }

        else -> {
            // Aucun contenu valide
            Text("Impossible de charger l'exercice.")
        }
    }

    // Menu déroulant
    MenuDeroulant(
        navController = navController,
        menuDeroulantViewModel = menuDeroulantViewModel,
        onDismissRequest = { menuDeroulantViewModel.closeMenu() },
        connexionViewModel = connexionViewModel
    )
}
