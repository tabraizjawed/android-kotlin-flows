package me.tabraiz.learn.kotlin.flow.ui.retrywhen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.tabraiz.learn.kotlin.flow.data.api.ApiHelper
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseHelper
import me.tabraiz.learn.kotlin.flow.utils.DispatcherProvider
import me.tabraiz.learn.kotlin.flow.ui.base.UiState
import java.io.IOException

class RetryWhenViewModel(
    val apiHelper: ApiHelper,
    dbHelper: DatabaseHelper,
    val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiState: StateFlow<UiState<String>> = _uiState

    fun startTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _uiState.value = UiState.Loading
            // do a long running task
            doLongRunningTask()
                .flowOn(dispatcherProvider.default)
                .retryWhen { cause, attempt ->
                    if (cause is IOException && attempt < 3) {
                        delay(2000)
                        return@retryWhen true
                    } else {
                        return@retryWhen false
                    }
                }
                .catch {
                    _uiState.value = UiState.Error("Something Went Wrong")
                }
                .collect {
                    _uiState.value = UiState.Success("Task Completed")
                }
        }
    }

    private fun doLongRunningTask(): Flow<Int> {
        return flow {
            // your code for doing a long running task
            // Added delay, random number, and exception to simulate

            delay(2000)

            val randomNumber = (0..2).random()

            if (randomNumber == 0) {
                throw IOException()
            } else if (randomNumber == 1) {
                throw IndexOutOfBoundsException()
            }

            delay(2000)
            emit(0)
        }
    }

}