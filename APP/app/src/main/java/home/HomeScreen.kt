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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.R
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.MyBottomAppBar
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import common.connexion.ConnexionViewModel
import common.ui.colors.PrimaryColor
import common.ui.colors.SecondaryColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val menuDeroulantViewModel = MenuDeroulantViewModel()
    val connexionViewModel = ConnexionViewModel()

    if (connexionViewModel.isConnected.value) {
        Scaffold(
            bottomBar = { MyBottomAppBar(menuDeroulantViewModel) },
        ) { // Contenu principal de l'écran
            MainContentConnected()
            MenuDeroulant(
                menuDeroulantViewModel,
                onDismissRequest = { menuDeroulantViewModel.closeMenu() },
                connexionViewModel
            )

        }
    } else {
        Scaffold(
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.background(PrimaryColor),
                    containerColor = PrimaryColor,
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(), // Prend toute la taille disponible
                        horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
                        verticalArrangement = Arrangement.Center // Centre verticalement le contenu
                    )
                    {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .clip(RectangleShape),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryColor // Couleur du fond du bouton
                            ),
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "home",
                                modifier = Modifier.size(45.dp),
                                colorFilter = ColorFilter.tint(Color.Black)
                            )
                        }
                    }
                }
            }
        ) { // Contenu principal de l'écran
            MainContentConnexion(connexionViewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable fun DefaultPreview(){
    MainScreen()
}