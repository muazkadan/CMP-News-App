package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import presentation.screen.categories.CategoriesScreen
import presentation.screen.details.DetailsScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.CategoriesScreen.route,
    ) {
        composable(route = Screen.CategoriesScreen.route) {
            CategoriesScreen(
                navController,
            )
        }
        composable(
            route = Screen.NewsDetailsScreen.route + "/{category}",
            arguments =
            listOf(
                navArgument(name = "category") {
                    type = NavType.StringType
                },
            ),
        ) {
            val category = remember { it.arguments?.getString("category") ?: "" }
            DetailsScreen(navController = navController, category = category)
        }
    }
}
