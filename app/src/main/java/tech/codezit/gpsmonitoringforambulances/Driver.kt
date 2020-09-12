package tech.codezit.gpsmonitoringforambulances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_driver.*

class Driver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver)
    }

    // When the registration code is entered.
    fun submit() {
        if (pin.text!!.length < 6) {
            // create a dialog
            //alternative
            Toast.makeText(applicationContext, "Please enter a valid code", Toast.LENGTH_LONG)
                .show()
        }
        val code = pin.text!!.map { it.toInt() }
    }

}