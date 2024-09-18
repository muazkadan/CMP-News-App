package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import presentation.screen.categories.CategoriesScreen
import presentation.screen.details.DetailsScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.CategoriesScreen,
    ) {
        composable<Screen.CategoriesScreen> {
            CategoriesScreen(
                navController,
            )
        }
        composable<Screen.NewsDetailsScreen> {
            val newsDetailsScreen = it.toRoute<Screen.NewsDetailsScreen>()
            DetailsScreen(navController = navController, category = newsDetailsScreen.category)
        }
    }
}
