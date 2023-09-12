package me.tabraiz.learn.kotlin.flow.ui.flowon

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_long_running_task.progressBar
import kotlinx.android.synthetic.main.activity_long_running_task.textView
import me.tabraiz.learn.kotlin.flow.R
import me.tabraiz.learn.kotlin.flow.data.api.ApiHelperImpl
import me.tabraiz.learn.kotlin.flow.data.api.RetrofitBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseHelperImpl
import me.tabraiz.learn.kotlin.flow.ui.base.ViewModelFactory
import me.tabraiz.learn.kotlin.flow.utils.DefaultDispatcherProvider

class FlowOnActivity : AppCompatActivity() {

    private lateinit var viewModel: FlowOnViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_running_task)
        setupTextView()
        setupViewModel()
        setupTask()
    }

    private fun setupTextView() {
        progressBar.visibility = View.GONE
        textView.text = getString(R.string.check_logcat)
        textView.visibility = View.VISIBLE
    }

    private fun setupTask() {
        viewModel.startFlowOnTask()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this, ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext)),
                DefaultDispatcherProvider()
            )
        )[FlowOnViewModel::class.java]
    }
}
