package br.senai.sp.jandira.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.senai.sp.jandira.navigation.login.LoginScreen
import br.senai.sp.jandira.navigation.menu.MenuScreen
import br.senai.sp.jandira.navigation.pedidos.PedidosScreen
import br.senai.sp.jandira.navigation.perfil.PerfilScreen
import br.senai.sp.jandira.navigation.ui.theme.NavigationTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentScope.SlideDirection.End,
                                animationSpec = tween(2000)
                            ) + fadeIn(tween(1000))
                        },
                        exitTransition = {
                            scaleOut(tween(1500)) + slideOutOfContainer(AnimatedContentScope.SlideDirection.End , tween(2000)) + fadeOut(
                                tween(1000)
                            )
//                            slideOutOfContainer(
//                                AnimatedContentScope.SlideDirection.Start,
//                                tween(1500)
//                            )
                        }
                    ){
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController)}
                        composable(route = "pedidos") { PedidosScreen(navController) }
                        composable(route = "perfil") { PerfilScreen(navController) }
                    }
                }
            }
        }
    }
}

