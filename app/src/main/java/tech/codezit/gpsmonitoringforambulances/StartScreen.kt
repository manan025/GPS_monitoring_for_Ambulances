package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_start_screen.*

class StartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)
        /*val loginImageUri = "https://www.figma.com/file/K5pRx2kVU2rfE9WlygxRLr/Untitled?node-id=1%3A14"
        Picasso
            .get()
            .load(loginImageUri)
            .into(login_image)*/
    }

    fun started(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}