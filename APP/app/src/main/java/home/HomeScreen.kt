package home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app.R
import androidx.navigation.NavHostController
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import common.connexion.ConnexionViewModel
import common.ui.colors.PrimaryColor
import common.ui.colors.SecondaryColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, menuDeroulantViewModel: MenuDeroulantViewModel,connexionViewModel: ConnexionViewModel) {


    if (connexionViewModel.isConnected.value) {
        Scaffold(
           // bottomBar = { MyBottomAppBar(menuDeroulantViewModel) },
        ) { // Contenu principal de l'écran
            MainContentConnected(navController)
            MenuDeroulant(
                navController,
                menuDeroulantViewModel,
                onDismissRequest = { menuDeroulantViewModel.closeMenu() },
                connexionViewModel
            )

        }
    } else {
        Scaffold(
        ) { // Contenu principal de l'écran
            MainContentConnexion(connexionViewModel)
        }
    }
}

/* Désolé plus de preview ça marche pas avec la nav
@Preview(showBackground = true)
@Composable fun DefaultPreview(){
    MainScreen()
}*/
