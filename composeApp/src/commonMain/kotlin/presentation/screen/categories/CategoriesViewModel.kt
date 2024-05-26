package presentation.screen.categories

import androidx.lifecycle.ViewModel
import data.model.CategoryModel
import kotlinx.coroutines.flow.MutableStateFlow

class CategoriesViewModel : ViewModel() {
    var categories =
        MutableStateFlow(
            listOf(
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
            ),
        )
        private set
}
