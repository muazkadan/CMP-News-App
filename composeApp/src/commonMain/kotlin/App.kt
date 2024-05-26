import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import presentation.navigation.Navigation
import presentation.ui.NewsAppTheme

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules()
    }) {
        NewsAppTheme {
            Navigation()
        }
    }
}
