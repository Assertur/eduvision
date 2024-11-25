package common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.navigation.HOME_ROUTE
import com.example.app.R
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import common.connexion.ConnexionViewModel
import common.ui.colors.BackgroundColor
import common.ui.colors.PrimaryColor
import common.ui.colors.SecondaryColor

@Composable
fun TravauxPage (navController: NavController, menuDeroulantViewModel: MenuDeroulantViewModel, connexionViewModel: ConnexionViewModel) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)

    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally, // Centre horizontalement
            verticalArrangement = Arrangement.Center, // Centre verticalement le contenu
            modifier = Modifier.padding(30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.travaux),
                contentDescription = "Travaux",
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(60.dp)
            )
            Text(
                "Cette page est encore en cours de production !",
                fontSize = 18.sp
                )
            Button(
                onClick = {navController.navigate(HOME_ROUTE)},
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clip(RoundedCornerShape(10.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor // Couleur du fond du bouton
                )
            ) {
                Text(
                    "Retour à l'accueil",
                    fontSize = 18.sp
                )
            }
        }
    }
    MenuDeroulant(
        navController,
        menuDeroulantViewModel,
        onDismissRequest = { menuDeroulantViewModel.closeMenu() },
        connexionViewModel
    )
}