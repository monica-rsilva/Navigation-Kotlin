package br.senai.sp.jandira.navigation.perfil

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
fun PerfilScreen(navController: NavController, nome: String, idade:String) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green))
    {
//        enterpolaçao - imprimir o conteudo da variavel mesmo estando dentro das aspas
        Text(text = "Perfil - $nome - $idade")
        Button(onClick = {  navController.navigate("menu")}) {
            Text(text = "Voltar")
        }
    }
}

