package presentation.navigation

sealed class Screen(val route: String) {
    data object CategoriesScreen : Screen("categories_screen")

    data object NewsDetailsScreen : Screen("details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
