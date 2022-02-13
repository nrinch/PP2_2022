package na.severinchik.lesson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import na.severinchik.lesson4.fragments.MainFragment
import na.severinchik.lesson4.fragments.SecondaryFragment

class FragmentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, MainFragment(), MainFragment.TAG)
            .commit()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, SecondaryFragment.newInstance("Hello"), SecondaryFragment.TAG)
            .commit()

        supportFragmentManager.fragments.forEach {
            println("--> $it ${it.tag} ")
        }

    }
}