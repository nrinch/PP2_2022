package na.severinchik.lesson6.presentation.screen.dogscats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.squareup.picasso.Picasso
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.R
import na.severinchik.lesson6.databinding.ActivityDogsCatBinding

class DogsCatActivity : AppCompatActivity() {

    private var _binding: ActivityDogsCatBinding? = null
    private val binding: ActivityDogsCatBinding
        get() = _binding!!

    private val viewModel: DogsCatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDogsCatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adcUpdate.setOnClickListener { viewModel.fetch() }

        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { state ->
                binding.adcOutputFact.text = state.fact
//                Picasso.get().load(state.imageLink).placeholder(R.drawable.ic_launcher_foreground)
//                    .into(binding.adcImage)

                binding.adcImage.load(state.imageLink){
                    scale(Scale.FIT)
                    transformations(CircleCropTransformation())
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}