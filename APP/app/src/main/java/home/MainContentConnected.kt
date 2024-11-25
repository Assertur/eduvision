package home

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.LinearProgressIndicator
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app.R
import common.connexion.ConnexionViewModel
import common.ui.colors.BackgroundColor
import common.ui.colors.ItemColor
import common.ui.colors.PrimaryColor
import common.ui.colors.SecondaryColor

@Composable
fun MainContentConnected(navController: NavHostController) {
    // Utilisation d'un état de scroll pour la troisième partie
    val scrollState = rememberScrollState()

    val imgCrayon = R.drawable.crayon
    val imgTrophe = R.drawable.trophe
    val imgChap = R.drawable.chapitre

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Les trois premières sections prennent le même espace vertical
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Partie 1 et 2
            Column(
                modifier = Modifier
                    .weight(1f) // La partie 1 et 2 prennent la moitié de la largeur
                    .padding(end = 8.dp) // Espace entre les colonnes
            ) {
                // Partie 1
                PartWithImageAndText(
                    imageResId = imgCrayon,
                    text = "Dernier exercice\n(Calcul oiseaux)",
                    115,
                    navController,
                    "exercice_exemple"
                )

                Spacer(modifier = Modifier.height(8.dp)) // Espacement entre Partie 1 et Partie 2

                // Partie 2
                PartWithImageAndText(
                    imageResId = imgChap,
                    text = "Cours associé",
                    115,
                    navController,
                    "exercice_exemple"
                )
            }

            // Partie 3
            Column(
                modifier = Modifier
                    .weight(1f) // La partie 3 prend la moitié de la largeur
                    .verticalScroll(scrollState) // Scrollable
                    .padding(horizontal = 15.dp) // Espace entre les colonnes
                    .clip(RoundedCornerShape(25.dp))
                    .background(ItemColor)
            ) {
                // Liste d'éléments pour la troisième partie
                val items = listOf(
                    ProgressItem(imgCrayon, "Calcul pommes", 0.75f),
                    ProgressItem(imgCrayon, "Napoléon en images", 0.45f),
                    ProgressItem(imgCrayon, "Rooms in the house", 0.85f)
                )

                // Afficher chaque élément
                items.forEach { item ->
                    ProgressItemRow(item, 3)
                    Spacer(modifier = Modifier.height(8.dp)) // Espacement entre chaque élément
                }

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor // Couleur du fond du bouton
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 10.dp)
                ) {
                    Text("Voir plus", fontSize = 18.sp)
                }
            }
        }

        // Partie 4 - Liste d'éléments similaire à la partie 3
        // Spacer(modifier = Modifier.height(16.dp)) // Espacement entre les sections verticales

        // Liste d'éléments pour la quatrième partie
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 15.dp, end = 15.dp, bottom = 20.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(ItemColor)
        ) {
            Text(
                "Exercices finis",
                fontSize = 25.sp,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
            )

            val items = listOf(
                ProgressItem(imgTrophe, "Calcul oiseaux", 0.65f),
                ProgressItem(imgTrophe, "Scrum pizzas", 0.30f),
                ProgressItem(imgTrophe, "Item C", 0.90f)
            )

            // Afficher chaque élément
            items.forEach { item ->
                ProgressItemRow(item, 4)
                Spacer(modifier = Modifier.height(8.dp)) // Espacement entre chaque élément
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryColor // Couleur du fond du bouton
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 10.dp)
            ) {
                Text("Voir plus", fontSize = 18.sp)
            }
        }
    }
}

// Classe de données pour représenter chaque élément avec une image, un texte et une progression
data class ProgressItem(val imageResId: Int, val text: String, val progress: Float)

// Composable pour afficher un élément avec image, texte, barre de progression et pourcentage
@Composable
fun ProgressItemRow(item: ProgressItem, number: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image à gauche
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.text,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp) // Taille de l'image
                    .padding(end = 8.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            // Texte et barre de progression
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.text,
                    fontSize = 16.sp
                )
                if (number == 4) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 15.dp)
                    ) {
                        // Barre de progression
                        LinearProgressIndicator(
                            progress = item.progress,
                            modifier = Modifier
                                .weight(1f)
                                .height(8.dp)
                                .padding(end = 8.dp)
                        )
                        // Pourcentage
                        Text(
                            text = "${(item.progress * 100).toInt()}%",
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PartWithImageAndText(
    imageResId: Int,
    text: String,
    taille: Int,
    navController: NavHostController,
    route: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(ItemColor)
            .clickable {
                navController.navigate(route)
            },
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = text,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(taille.dp)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(SecondaryColor)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 10.dp),
            textAlign = TextAlign.Center
        )
    }
}