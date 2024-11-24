package common.bottomAppBar.menuDeroulant

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.R
import ui.colors.BackgroundColor
import ui.colors.ItemColor
import ui.colors.PrimaryColor
import ui.colors.SecondaryColor
import ui.colors.TextColor1


@Composable
fun MenuDeroulant(
    menuDeroulantViewModel: MenuDeroulantViewModel,
    onDismissRequest: () -> Unit,
) {

    if (menuDeroulantViewModel.isMenuExpanded.value) {
        // Superposition d'un fond semi-transparent
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f)) // Couleur semi-transparente pour griser l'écran
                .clickable { onDismissRequest() } // Permet de fermer le menu en cliquant en dehors
        ) {
            // Menu déroulant personnalisé à l'intérieur d'un BoxWithConstraints
            BoxWithConstraints(
                modifier = Modifier
                    .align(Alignment.BottomStart) // Aligner le menu en bas de l'écran
            ) {
                val screenWidth = maxWidth
                val screenHeight = maxHeight

                // Conteneur pour le menu déroulant
                Box(
                    modifier = Modifier
                        .width(screenWidth * 0.60f)  // 60% de la largeur de l'écran
                        .height(screenHeight * 0.57f) // 57% de la hauteur de l'écran
                        .padding(start = 5.dp, bottom = 115.dp) // Marge intérieure
                        .clip(RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp, topEnd = 20.dp, bottomEnd = 20.dp))
                        .background(BackgroundColor)      // Couleur de fond du menu déroulant
                ) {
                    // Contenu du menu déroulant
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.BottomStart)
                            .padding(horizontal = 20.dp)
                        ,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Spacer(modifier = Modifier.weight(1.0f))
                        Button(
                            onClick = {
                                /* Action pour l'élément 1 */
                                onDismissRequest()
                            },
                            modifier = Modifier.clip(RectangleShape)
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SecondaryColor // Couleur du fond du bouton
                            ),
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text("Matières",
                                color = TextColor1,
                                fontSize = 25.sp,
                            )
                        }
                        Button(
                            onClick = {
                                /* Action pour l'élément 1 */
                                onDismissRequest()
                            },
                            modifier = Modifier.clip(RectangleShape)
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SecondaryColor // Couleur du fond du bouton
                            ),
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text("A faire",
                                color = TextColor1,
                                fontSize = 25.sp,
                            )
                        }
                        Button(
                            onClick = {
                                /* Action pour l'élément 1 */
                                onDismissRequest()
                            },
                            modifier = Modifier.clip(RectangleShape)
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SecondaryColor // Couleur du fond du bouton
                            ),
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text("Groupes",
                                color = TextColor1,
                                fontSize = 25.sp,
                            )
                        }
                        Button(
                            onClick = {
                                /* Action pour l'élément 1 */
                                onDismissRequest()
                            },
                            modifier = Modifier.clip(RectangleShape)
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SecondaryColor // Couleur du fond du bouton
                            ),
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text("Historique",
                                color = TextColor1,
                                fontSize = 25.sp,
                            )
                        }
                        Button(
                            onClick = {
                                /* Action pour l'élément 1 */
                                onDismissRequest()
                            },
                            modifier = Modifier.clip(RectangleShape)
                                .fillMaxWidth().align(Alignment.Start)
                                .padding(vertical = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SecondaryColor // Couleur du fond du bouton
                            ),
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text("Profil",
                                color = TextColor1,
                                fontSize = 25.sp,
                            )
                        }
                        Row {
                            Spacer(modifier = Modifier.weight(1.0f))
                            Image(
                                painter = painterResource(id = R.drawable.parametres),
                                contentDescription = "Paramètres",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(10.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.deconnexion),
                                contentDescription = "Déconnexion",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(10.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

