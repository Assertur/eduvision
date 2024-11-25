package home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import ui.colors.SecondaryColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, menuDeroulantViewModel: MenuDeroulantViewModel) {

    Scaffold(
//        bottomBar = { MyBottomAppBar(menuDeroulantViewModel) },
        modifier = Modifier.background(SecondaryColor)
    ) { // Contenu principal de l'écran
        MainContentConnected(navController = navController)
        MenuDeroulant(
            menuDeroulantViewModel,
            onDismissRequest = { menuDeroulantViewModel.closeMenu() }
        )

    }
}

/* Désolé plus de preview ça marche pas avec la nav
@Preview(showBackground = true)
@Composable fun DefaultPreview(){
    MainScreen()
}*/
