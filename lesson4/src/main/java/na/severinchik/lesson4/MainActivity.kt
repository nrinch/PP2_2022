package na.severinchik.lesson4

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.parcelize.Parcelize

private const val MAIN_ACTIVITY_TAG = "main_activity_tag"
private const val EDIT_FIELD_KEY = "edit_field_key"

class MainActivity : AppCompatActivity() {

    private lateinit var editField: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("-->> on Create")
        Log.d(MAIN_ACTIVITY_TAG, "onCreate: ")

        editField = findViewById(R.id.am_edit)
        button = findViewById(R.id.am_button_route_to_another_screen)

        button.setOnClickListener {
//            openWebPage("https://developer.android.com/guide/components/intents-common?hl=ru#ViewUrl")
//            runExplicitIntent()
            runExplicitIntentWithParam("Hi")
        }
//        val titleTextView = findViewById<TextView>(R.id.am_title)
//        val appNameString = getString(R.string.app_name)

        Intent(this, BottomNavActivity::class.java).apply { startActivity(this) }
    }

    override fun onStart() {
        super.onStart()
        println("-->> on Start")
    }

    override fun onResume() {
        super.onResume()
        println("-->> on Resume")
    }

    override fun onRestart() {
        super.onRestart()
        println("-->> on Restart")
    }

    override fun onPause() {
        super.onPause()
        println("-->> on Pause")
    }

    override fun onStop() {
        super.onStop()
        println("-->> on Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("-->> on Destroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EDIT_FIELD_KEY, editField.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        editField.setText(savedInstanceState.getString(EDIT_FIELD_KEY, String.EMPTY))
    }

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }

    private fun runExplicitIntent() {
        val intent = Intent(this, SecondaryActivity::class.java)
        startActivity(intent)
        finish()


//        Intent(this, SecondaryActivity::class.java).apply {
//            startActivity(this)
//        }
    }

    private fun runExplicitIntentWithParam(param: String) {
        val userInfo = UserInfo("john", "doe")

        Intent(this, SecondaryActivity::class.java).apply {
            putExtra(SOME_DATA, param)
            putExtra(SOME_DATA2, userInfo)
            startActivity(this)
        }
    }

    companion object {
        const val SOME_DATA = "some_data_from_main_activity"
        const val SOME_DATA2 = "some_data_from_main_activity"

    }
}

val String.Companion.EMPTY
    get() = ""

class LocalResources(private val context: Context) {
    val appNameString = context.getString(R.string.app_name)
}


data class User(val name: String, val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: String.EMPTY,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}

@Parcelize
data class UserInfo(val name: String, val surname: String) : Parcelable {
    companion object {
        val DEFAULT = UserInfo(name = String.EMPTY, surname = String.EMPTY)
    }
}