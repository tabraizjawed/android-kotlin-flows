package me.tabraiz.learn.kotlin.flow.ui.retrofit.series

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.coroutines.launch
import me.tabraiz.learn.kotlin.flow.R
import me.tabraiz.learn.kotlin.flow.data.api.ApiHelperImpl
import me.tabraiz.learn.kotlin.flow.data.api.RetrofitBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseBuilder
import me.tabraiz.learn.kotlin.flow.data.local.DatabaseHelperImpl
import me.tabraiz.learn.kotlin.flow.data.model.ApiUser
import me.tabraiz.learn.kotlin.flow.ui.base.ApiUserAdapter
import me.tabraiz.learn.kotlin.flow.utils.DefaultDispatcherProvider
import me.tabraiz.learn.kotlin.flow.ui.base.UiState
import me.tabraiz.learn.kotlin.flow.ui.base.ViewModelFactory

class SeriesNetworkCallsActivity : AppCompatActivity() {

    private lateinit var viewModel: SeriesNetworkCallsViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiUserAdapter(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            progressBar.visibility = View.GONE
                            renderList(it.data)
                            recyclerView.visibility = View.VISIBLE
                        }
                        is UiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
                            progressBar.visibility = View.GONE
                            Toast.makeText(
                                this@SeriesNetworkCallsActivity,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext)),
                DefaultDispatcherProvider()
            )
        )[SeriesNetworkCallsViewModel::class.java]
    }
}
