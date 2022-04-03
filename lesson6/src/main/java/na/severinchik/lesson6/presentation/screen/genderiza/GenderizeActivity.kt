package na.severinchik.lesson6.presentation.screen.genderiza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import na.severinchik.lesson6.R
import na.severinchik.lesson6.data.repository.ResultWrapper
import na.severinchik.lesson6.databinding.ActivityGenderizeBinding

class GenderizeActivity : AppCompatActivity() {

    private var _binding: ActivityGenderizeBinding? = null
    val binding: ActivityGenderizeBinding
        get() = _binding!!

    private val viewModel: GenderizeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGenderizeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.agSend.setOnClickListener {
            val name = binding.agName.text.toString()
            viewModel.check(name)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { result ->
                binding.agResultTv.text = when (result) {
                    is ResultWrapper.Error -> "Error ${result.message}"
                    ResultWrapper.Loading -> "Loading....."
                    is ResultWrapper.Success ->
                        "Name:${result.data.name}\n Gender:${result.data.gender} \n Probability:${result.data.probability}"
                }
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}