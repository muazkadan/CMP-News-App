import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.navigation.Navigation

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigation()
    }
}
