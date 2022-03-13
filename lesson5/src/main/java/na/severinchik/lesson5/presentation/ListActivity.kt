package na.severinchik.lesson5.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson5.databinding.ActivityListBinding
import na.severinchik.lesson5.presentation.listadapter.User
import na.severinchik.lesson5.presentation.listadapter.UserAdapter
import kotlin.random.Random

class ListActivity : AppCompatActivity() {

    private var _binding: ActivityListBinding? = null
    private val binding: ActivityListBinding
        get() = _binding!!

    private val viewModel: CleanArchitectureExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UserAdapter()
        binding.laRecycler.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.state.collect { list ->
                adapter.submitList(list)
                adapter.notifyDataSetChanged()
            }
        }
        viewModel.fetchAll()
        binding.alButtonAdd.setOnClickListener {
            viewModel.add(User(name = "John", surname = "${Random.nextInt()}"))
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}