package na.severinchik.lesson4.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import na.severinchik.lesson4.R

private const val PARAM_KEY = "param_key"

class SecondaryFragment : Fragment() {
    companion object {
        val TAG = "secondary_fragment_tag"

        fun newInstance(param: String): SecondaryFragment =
            SecondaryFragment().apply {
                arguments = bundleOf(
                    PARAM_KEY to param
                )
            }
    }

    private var param: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getString(PARAM_KEY)
                println("-->> received param $param")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_secondary, container, false)
        view.findViewById<Button>(R.id.fs_button).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MainFragment(), MainFragment.TAG).commit()
        }

        return view
    }


    override fun onResume() {
        super.onResume()
        parentFragmentManager.fragments.forEach {
            println("--> $it ${it.tag} ")
        }
    }
}