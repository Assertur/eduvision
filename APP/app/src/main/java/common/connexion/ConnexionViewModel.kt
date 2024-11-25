package common.connexion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ConnexionViewModel  : ViewModel() {
    // Variable d'état pour la visibilité du menu déroulant
    private val _isConnected = mutableStateOf(false)
    val isConnected: State<Boolean> = _isConnected
    var prenom = ""

    // Fonction pour ouvrir le menu
    fun connect(name : String) {
        _isConnected.value = true
        prenom = name
    }

    // Fonction pour fermer le menu
    fun disconnect() {
        _isConnected.value = false
        prenom = ""
    }
}