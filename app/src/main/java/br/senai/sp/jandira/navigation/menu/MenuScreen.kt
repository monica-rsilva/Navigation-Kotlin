package br.senai.sp.jandira.navigation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue))
    {
        Text(text = "MENU")

        Button(onClick = { navController.navigate("perfil")}) {
            Text(text = "Perfil")
        }
        Button(onClick = { navController.navigate("pedidos") }) {
            Text(text = "Pedidos")
        }
        Button(onClick = { navController.navigate("login") }) {
            Text(text = "Sair")
        }
    }
}
