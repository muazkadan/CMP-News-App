package presentation.screen.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cmpnewsapp.composeapp.generated.resources.Res
import cmpnewsapp.composeapp.generated.resources.app_name
import data.model.CategoryModel
import org.jetbrains.compose.resources.stringResource
import presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun CategoriesScreen(navController: NavController) {
    val gridState = rememberLazyGridState()
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(topAppBarState)
    val windowSizeClass = calculateWindowSizeClass()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = stringResource(Res.string.app_name),
                            style = MaterialTheme.typography.labelLarge,
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) {
        LazyVerticalGrid(
            modifier =
                Modifier
                    .fillMaxSize()
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                    .padding(it),
            state = gridState,
            columns =
                when (windowSizeClass.widthSizeClass) {
                    WindowWidthSizeClass.Compact ->
                        GridCells.Adaptive(140.dp)

                    WindowWidthSizeClass.Medium ->
                        GridCells.Adaptive(200.dp)

                    else -> GridCells.Adaptive(320.dp)
                },
        ) {
            items(Categories.categoriesList) { category ->
                Card(
                    modifier =
                        Modifier
                            .padding(8.dp)
                            .aspectRatio(2F)
                            .clickable {
                                navController.navigate(Screen.NewsDetailsScreen.withArgs(category.value))
                            },
                    elevation = CardDefaults.cardElevation(10.dp),
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = category.name,
                            fontSize = 20.sp,
                        )
                    }
                }
            }
        }
    }
}

object Categories {
    val categoriesList =
        mutableStateListOf(
            CategoryModel("All", "all"),
            CategoryModel("National", "national"),
            CategoryModel("Business", "business"),
            CategoryModel("Sports", "sports"),
            CategoryModel("World", "world"),
            CategoryModel("Politics", "politics"),
            CategoryModel("Technology", "technology"),
            CategoryModel("Startup", "startup"),
            CategoryModel("Entertainment", "entertainment"),
            CategoryModel("Miscellaneous", "miscellaneous"),
            CategoryModel("Hatke", "hatke"),
            CategoryModel("Science", "science"),
            CategoryModel("Automobile", "automobile"),
        )
}
