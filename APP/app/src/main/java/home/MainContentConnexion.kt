package home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.app.R
import common.connexion.ConnexionViewModel
import common.ui.colors.BackgroundColor
import common.ui.colors.SecondaryColor


@Composable
fun MainContentConnexion(connexionViewModel: ConnexionViewModel) {

    val errorShown by remember { mutableStateOf(false) }
    var id by remember { mutableStateOf("") }
    var mdp by remember { mutableStateOf("") }
    var registerd by remember { mutableStateOf(true) }

    if (registerd) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(top = 30.dp)
        ) {

            Text(
                "Connexion",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 40.dp, top = 40.dp, bottom = 30.dp)
            )

            if (errorShown) {
                Box(
                    modifier = Modifier.padding()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.attention),
                        contentDescription = "Attention",
                        modifier = Modifier.padding()
                    )
                    Text(
                        "Votre identifiant ou mot de passe est incorrect",
                        color = Color.Red,
                        fontSize = 22.sp,
                        modifier = Modifier.padding()
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    "Identifiant",
                    fontSize = 20.sp
                )
                TextField(
                    value = id,
                    onValueChange = { newText ->
                        id = newText // Mettre à jour la variable d'état
                    },
                    placeholder = { Text("Nom Prenom") }, // Texte d'indication
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(SecondaryColor),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next // Pour passer au champ suivant
                    )
                )
            }

            Box(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                var passwordVisible by remember { mutableStateOf(false) }
                Text(
                    "Mot de passe",
                    fontSize = 20.sp
                )
                TextField(
                    value = mdp,
                    onValueChange = { newText ->
                        mdp = newText // Mettre à jour la variable d'état
                    },
                    placeholder = { Text("Mot de passe") }, // Texte d'indication
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else
                            Icons.Filled.VisibilityOff

                        // Icône pour afficher/masquer le mot de passe
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = image,
                                contentDescription = if (passwordVisible) "Masquer le mot de passe" else "Afficher le mot de passe"
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(SecondaryColor),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done // Pour passer au champ suivant
                    )
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 50.dp, top = 15.dp)
            ) {
                Text("Se connecter", fontSize = 20.sp)
            }

            Text(
                "S'inscrire",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 70.dp, top = 10.dp)
                    .clickable() { registerd = false },
                color = Color.Blue
            )
        }
    }

    else {

        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var accountType by remember { mutableStateOf("Élève") } // Valeur par défaut pour le type de compte

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundColor)
                .padding(30.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                "Inscription",
                modifier = Modifier.padding(start = 40.dp, top = 40.dp, bottom = 30.dp),
                fontSize = 30.sp
                )
            // Champ pour le prénom
            TextField(
                value = firstName,
                onValueChange = { newFirstName -> firstName = newFirstName },
                label = { Text("Prénom") },
                placeholder = { Text("Entrez votre prénom") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(SecondaryColor),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next // Pour passer au champ suivant
                )
            )

            // Champ pour le nom
            TextField(
                value = lastName,
                onValueChange = { newLastName -> lastName = newLastName },
                label = { Text("Nom") },
                placeholder = { Text("Entrez votre nom") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(SecondaryColor),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next // Pour passer au champ suivant
                )
            )

            // Champ pour le mot de passe
            TextField(
                value = password,
                onValueChange = { newPassword -> password = newPassword },
                label = { Text("Mot de passe") },
                placeholder = { Text("Entrez votre mot de passe") },
                visualTransformation = PasswordVisualTransformation(), // Masque le texte pour le mot de passe
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(SecondaryColor),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password // Type clavier pour mot de passe
                )
            )

            // Type de compte avec des boutons radio
            Text(
                text = "Type de compte",
                modifier = Modifier.padding(top = 10.dp, bottom = 5.dp),
                fontSize = 20.sp
            )

            // Options de type de compte avec des RadioButtons
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButtonOption(
                    label = "Professeur",
                    selected = accountType == "Professeur",
                    onSelect = { accountType = "Professeur" }
                )
                RadioButtonOption(
                    label = "Élève",
                    selected = accountType == "Élève",
                    onSelect = { accountType = "Élève" }
                )
                RadioButtonOption(
                    label = "Parent",
                    selected = accountType == "Parent",
                    onSelect = { accountType = "Parent" }
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 50.dp, top = 15.dp)
            ) {
                Text("S'inscrire", fontSize = 20.sp)
            }

            Text(
                "Se connecter",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 50.dp, top = 10.dp)
                    .clickable() { registerd = true },
                color = Color.Blue
            )
        }
    }
}

// Composable pour une option de bouton radio
@Composable
fun RadioButtonOption(
    label: String,
    selected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 12.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect
        )
        Text(
            text = label,
            fontSize = 16.sp
        )
    }
}