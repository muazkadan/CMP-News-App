package presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object CategoriesScreen : Screen()

    @Serializable
    data class NewsDetailsScreen(
        val category: String,
    ) : Screen()
}
