package presentation.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.model.News
import data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: NewsRepository,
) : ViewModel() {
    var uiState = MutableStateFlow(UiState())
        private set

    fun getNews(category: String) =
        viewModelScope.launch {
            val response = repository.getCategoryNews(category)
            uiState.update { uiState ->
                uiState.copy(
                    isLoading = false,
                    news = response.data,
                )
            }
        }

    data class UiState(
        val news: List<News> = emptyList(),
        val isLoading: Boolean = true,
    )
}
