package common.connexion

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ConnexionViewModel : ViewModel() {
    // Variable d'état pour indiquer si l'utilisateur est connecté
    private val _isConnected = mutableStateOf(false)
    val isConnected: State<Boolean> = _isConnected

    // Stocke le prénom de l'utilisateur
    private val _prenom = mutableStateOf("")
    val prenom: State<String> = _prenom

    // Fonction pour connecter l'utilisateur
    fun connect(userPrenom: String) {
        _prenom.value = userPrenom
        _isConnected.value = true
    }

    // Fonction pour déconnecter l'utilisateur
    fun disconnect() {
        _isConnected.value = false
        _prenom.value = ""
    }
}