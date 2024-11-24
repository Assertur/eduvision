package home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import common.bottomAppBar.menuDeroulant.MenuDeroulant
import common.bottomAppBar.MyBottomAppBar
import common.bottomAppBar.menuDeroulant.MenuDeroulantViewModel
import ui.colors.SecondaryColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    var menuDeroulantViewModel = MenuDeroulantViewModel()

    Scaffold(
        bottomBar = { MyBottomAppBar(menuDeroulantViewModel) },
        modifier = Modifier.background(SecondaryColor)
    )  { // Contenu principal de l'écran
        MainContentConnected()
        MenuDeroulant(
            menuDeroulantViewModel,
            onDismissRequest = { menuDeroulantViewModel.closeMenu() }
        )

    }
}

@Preview(showBackground = true)
@Composable fun DefaultPreview(){
    MainScreen()
}