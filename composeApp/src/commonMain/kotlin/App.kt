import androidx.compose.runtime.*
import di.dataModule
import di.networkModule
import di.viewModelModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import presentation.navigation.Navigation
import presentation.ui.NewsAppTheme

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(networkModule(), dataModule(), viewModelModule())
    }) {
        NewsAppTheme {
            Navigation()
        }
    }
}
