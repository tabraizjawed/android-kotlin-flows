package me.tabraiz.learn.kotlin.flow.ui.task.twotasks

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.android.synthetic.main.activity_long_running_task.*
import kotlinx.android.synthetic.main.activity_recycler_view.progressBar
import kotlinx.coroutines.launch
import me.tabraiz.learn.kotlin.flow.R
import me.tabraiz.learn.kotlin.flow.data.api.ApiHelperImpl
import me.tabraiz.learn.kotlin.flow.data.api.RetrofitBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseHelperImpl
import me.tabraiz.learn.kotlin.flow.utils.DefaultDispatcherProvider
import me.tabraiz.learn.kotlin.flow.ui.base.UiState
import me.tabraiz.learn.kotlin.flow.ui.base.ViewModelFactory

class TwoLongRunningTasksActivity : AppCompatActivity() {

    private lateinit var viewModel: TwoLongRunningTasksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_running_task)
        setupViewModel()
        setupLongRunningTask()
    }

    private fun setupLongRunningTask() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            progressBar.visibility = View.GONE
                            textView.text = it.data
                            textView.visibility = View.VISIBLE
                        }
                        is UiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                            textView.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@TwoLongRunningTasksActivity,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
        viewModel.startLongRunningTask()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext)),
                DefaultDispatcherProvider()
            )
        )[TwoLongRunningTasksViewModel::class.java]
    }
}
