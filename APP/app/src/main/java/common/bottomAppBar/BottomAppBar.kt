package common.bottomAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.NavController
import app.navigation.HOME_ROUTE
import com.example.app.R
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import common.ui.colors.PrimaryColor

@Composable
fun MyThreeLineButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width( 56.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor // Couleur du fond du bouton
        ),
        contentPadding = PaddingValues(0.dp) // Pas de padding pour centrer les lignes
    ) {
        // Utilisation d'une Column pour empiler les lignes
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Première ligne pleine
            Box(
                modifier = Modifier
                    .width(35.dp)  // Largeur de la ligne
                    .height(4.dp)  // Hauteur de la ligne
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.height(6.dp)) // Espace entre les lignes

            // Deuxième ligne pleine
            Box(
                modifier = Modifier
                    .width(35.dp)
                    .height(4.dp)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.height(6.dp))

            // Troisième ligne pleine
            Box(
                modifier = Modifier
                    .width(35.dp)
                    .height(4.dp)
                    .background(Color.Black)
            )
        }
    }
}


@Composable
fun MyBottomAppBar(
    menuDeroulantViewModel: MenuDeroulantViewModel?,
    navController: NavController
) {
    BottomAppBar(
        modifier = Modifier.background(PrimaryColor),
        containerColor = PrimaryColor
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MyThreeLineButton(onClick = {
                menuDeroulantViewModel?.toggleMenu()
            })
            Button(
                onClick = {
                navController.navigate(HOME_ROUTE)
            },
                modifier = Modifier.clip(RectangleShape),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor // Couleur du fond du bouton
                ),
                contentPadding = PaddingValues(5.dp),
                )  {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "home",
                    modifier = Modifier.size(45.dp),
                    colorFilter = ColorFilter.tint(Color.Black)
                )
            }
            IconButton(onClick = { /* Action pour la recherche */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Recherche",
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}
