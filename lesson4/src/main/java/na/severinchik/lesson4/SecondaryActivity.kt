package na.severinchik.lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val data = intent.getStringExtra(MainActivity.SOME_DATA) ?: String.EMPTY
        val data2 = intent.getParcelableExtra<UserInfo>(MainActivity.SOME_DATA) ?: UserInfo.DEFAULT

        findViewById<Button>(R.id.as_button)
            .apply { this.text = data }
            .setOnClickListener {
                Intent(this, MainActivity::class.java).apply { startActivity(this) }
                finish()
            }
    }
}