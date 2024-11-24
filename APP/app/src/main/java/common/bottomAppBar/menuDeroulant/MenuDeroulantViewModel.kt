package common.bottomAppBar.menuDeroulant

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class MenuDeroulantViewModel : ViewModel() {
    // Variable d'état pour la visibilité du menu déroulant
    private val _isMenuExpanded = mutableStateOf(false)
    val isMenuExpanded: State<Boolean> = _isMenuExpanded

    // Fonction pour ouvrir le menu
    fun openMenu() {
        _isMenuExpanded.value = true
    }

    // Fonction pour fermer le menu
    fun closeMenu() {
        _isMenuExpanded.value = false
    }

    // Fonction pour basculer l'état du menu
    fun toggleMenu() {
        _isMenuExpanded.value = !_isMenuExpanded.value
    }
}
