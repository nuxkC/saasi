package org.empresa.saas.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.empresa.saas.presentation.feature_auth.LoginScreen
import org.empresa.saas.presentation.feature_dashboard.DashboardScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}
