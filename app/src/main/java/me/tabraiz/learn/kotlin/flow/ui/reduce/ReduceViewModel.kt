package me.tabraiz.learn.kotlin.flow.ui.reduce

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import me.tabraiz.learn.kotlin.flow.data.api.ApiHelper
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseHelper
import me.tabraiz.learn.kotlin.flow.utils.DispatcherProvider
import me.tabraiz.learn.kotlin.flow.ui.base.UiState

class ReduceViewModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiState: StateFlow<UiState<String>> = _uiState

    fun startReduceTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _uiState.value = UiState.Loading
            val result = (1..5).asFlow()
                .reduce { a, b -> a + b }

            _uiState.value = UiState.Success(result.toString())
        }
    }


}