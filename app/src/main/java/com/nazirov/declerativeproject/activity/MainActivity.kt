package com.nazirov.declerativeproject.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nazirov.declerativeproject.activity.screen.DetailsScreen
import com.nazirov.declerativeproject.activity.screen.MainScreen
import com.nazirov.declerativeproject.activity.screen.MainScreenContent
import com.nazirov.declerativeproject.ui.theme.DeclerativeProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeclerativeProjectTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "main"
                    ) {
                        composable(route = "main") {
                            MainScreen(navController)
                        }
                        composable(
                            route = "details/{show_id}/{show_name}/{show_type}",
                            arguments = listOf(
                                navArgument("show_id") {
                                    type = NavType.StringType
                                },
                                navArgument("show_name") {
                                    type = NavType.StringType
                                },
                                navArgument("show_type") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val show_id = it.arguments?.getString("show_id")
                            val show_name = it.arguments?.getString("show_name")
                            val show_type = it.arguments?.getString("show_type")
                            DetailsScreen(navController, show_id!!,show_name!!,show_type!!)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DeclerativeProjectTheme() {
        MainScreenContent(null, false, listOf())
    }
}


