package na.severinchik.lesson5.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val viewModel: MainViewModel by viewModels()
//    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Intent(this, ListActivity::class.java).apply { startActivity(this) }
//        val factory = MainViewModelFactory(10)
//        viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycleScope.launchWhenResumed {
            viewModel.state.collect { data ->
                binding.amOutputTextField.text = data
            }
        }

        binding.amButton.setOnClickListener {
//            binding.amOutputTextField.text = viewModel.todoSmthWithApplication()
            viewModel.fetchData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}