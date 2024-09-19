package presentation.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.SubcomposeAsyncImage
import data.model.News
import org.koin.compose.viewmodel.koinViewModel

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3WindowSizeClassApi::class,
)
@Composable
fun DetailsScreen(
    category: String,
    navController: NavController,
    viewModel: DetailsViewModel = koinViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val windowSizeClass = calculateWindowSizeClass()

    LaunchedEffect(key1 = category) {
        viewModel.getNews(category = category)
    }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            title = {
                Text(
                    text = category,
                    fontWeight = FontWeight.Bold,
                )
            },
        )
    }) {
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier =
                    Modifier
                        .padding(it),
            ) {
                items(state.news) { news ->
                    NewsCard(
                        newsItem = news,
                        isLargeScreen = windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact,
                    )
                }
            }
        }
    }
}

@Composable
fun NewsCard(
    modifier: Modifier = Modifier,
    newsItem: News,
    isLargeScreen: Boolean = false,
) {
    Card(
        modifier =
            modifier
                .padding(8.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        if (isLargeScreen) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                ) {
                    Text(text = newsItem.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = newsItem.content, modifier = Modifier.padding(top = 6.dp))
                    androidx.compose.material.Text(
                        text =
                            buildString {
                                append(newsItem.author)
                                append(", ")
                                append(newsItem.date)
                                append(", ")
                                append(newsItem.time)
                            },
                        modifier = Modifier.padding(top = 6.dp),
                        fontSize = 10.sp,
                    )
                }
                SubcomposeAsyncImage(
                    model = newsItem.imageUrl,
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center,
                        ) {
                            CircularProgressIndicator()
                        }
                    },
                    modifier =
                        Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(start = 6.dp),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null,
                )
            }
        } else {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
            ) {
                Text(text = newsItem.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = newsItem.content, modifier = Modifier.padding(top = 6.dp))
                androidx.compose.material.Text(
                    text =
                        buildString {
                            append(newsItem.author)
                            append(", ")
                            append(newsItem.date)
                            append(", ")
                            append(newsItem.time)
                        },
                    modifier = Modifier.padding(top = 6.dp),
                    fontSize = 10.sp,
                )
                SubcomposeAsyncImage(
                    model = newsItem.imageUrl,
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center,
                        ) {
                            CircularProgressIndicator()
                        }
                    },
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 6.dp),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null,
                )
            }
        }
    }
}
