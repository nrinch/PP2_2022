package na.severinchik.lesson6.presentation.screen.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.databinding.ActivityMainBinding
import na.severinchik.lesson6.presentation.screen.dogscats.DogsCatActivity
import na.severinchik.lesson6.presentation.screen.genderiza.GenderizeActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.amButtonInsert.setOnClickListener { viewModel.insert() }
        binding.amButtonUpdate.setOnClickListener { viewModel.update() }
        binding.amButtonToDogsCats.setOnClickListener {
            Intent(this, DogsCatActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.amButtonToGenderize.setOnClickListener {
            Intent(this,GenderizeActivity::class.java).apply {
                startActivity(this)
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { listFacts ->
                binding.amOutputTv.text = listFacts.toString()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}