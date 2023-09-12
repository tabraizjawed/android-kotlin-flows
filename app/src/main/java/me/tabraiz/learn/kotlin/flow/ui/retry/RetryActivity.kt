package me.tabraiz.learn.kotlin.flow.ui.retry

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.android.synthetic.main.activity_retry.*
import kotlinx.coroutines.launch
import me.tabraiz.learn.kotlin.flow.R
import me.tabraiz.learn.kotlin.flow.data.api.ApiHelperImpl
import me.tabraiz.learn.kotlin.flow.data.api.RetrofitBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseHelperImpl
import me.tabraiz.learn.kotlin.flow.utils.DefaultDispatcherProvider
import me.tabraiz.learn.kotlin.flow.ui.base.UiState.*
import me.tabraiz.learn.kotlin.flow.ui.base.ViewModelFactory

class RetryActivity : AppCompatActivity() {

    private lateinit var viewModel: RetryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retry)
        setupViewModel()
        setupLongRunningTask()
    }

    private fun setupLongRunningTask() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is Success -> {
                            progressBar.visibility = View.GONE
                            textView.text = it.data
                            textView.visibility = View.VISIBLE
                        }
                        is Loading -> {
                            progressBar.visibility = View.VISIBLE
                            textView.visibility = View.GONE
                        }
                        is Error -> {
                            //Handle Error
                            progressBar.visibility = View.GONE
                            Toast.makeText(this@RetryActivity, it.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
        viewModel.startTask()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext)),
                DefaultDispatcherProvider()
            )
        )[RetryViewModel::class.java]
    }
}
