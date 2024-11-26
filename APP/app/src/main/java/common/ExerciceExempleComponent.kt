package common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.Game
import com.example.app.R
import common.ui.colors.ItemColor
import common.ui.colors.PrimaryColor
import common.ui.colors.SecondaryColor

@Composable
fun ExerciceLayout(
    hasResults: Boolean,
    progress: Float = 0f, // Par défaut 0, utilisé seulement si hasResults = true
    onStartClicked: () -> Unit, // Action pour "Démarrer l'exercice"
    onSeeMoreClicked: () -> Unit, // Action pour "Voir plus"
    navController: NavController,
    game: Game
) {
    LaunchedEffect(game) {
        val shouldNavigate = game.name == "" || game.description == ""
        if (shouldNavigate && navController.currentBackStackEntry?.destination?.route != "en_travaux") {
            navController.navigate("en_travaux") // Exercice non dispo
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(SecondaryColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Section Titre avec "bulle"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(ItemColor)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.crayon),
                    contentDescription = "Crayon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = game.name,
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Section Description
        Text(
            text = game.description,
            style = MaterialTheme.typography.body1.copy(
                color = Color.Gray,
                fontSize = 14.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Section Résultats précédents
        if (hasResults) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(ItemColor)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Résultats précédents",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Trophée
                    Image(
                        painter = painterResource(id = R.drawable.trophe),
                        contentDescription = "Trophée",
                        modifier = Modifier
                            .size(48.dp)
                            .padding(end = 8.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        // Barre de progression
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier.fillMaxWidth(),
                            color = PrimaryColor,
                            backgroundColor = Color.LightGray
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "${(progress * 100).toInt()}%",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Bouton "Voir plus"
                Button(
                    onClick = onSeeMoreClicked,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Voir plus")
                }
            }
        } else {
            Text(
                text = "Aucune tentative enregistrée",
                style = MaterialTheme.typography.body2.copy(
                    fontStyle = FontStyle.Italic,
                    color = Color.Gray
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Bouton "Démarrer l'exercice"
        Button(
            onClick = onStartClicked,
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Démarrer l'exercice",
                style = MaterialTheme.typography.button.copy(fontSize = 16.sp)
            )
        }
    }
}