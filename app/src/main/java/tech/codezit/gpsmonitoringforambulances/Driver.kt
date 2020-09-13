package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_driver.*
import java.sql.Driver

class Driver : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver)
    }

    // When the registration code is entered.
    fun submit(view: View) {
        if (pin.text!!.length < 6) {
            // create a dialog
            //alternative
            Toast.makeText(applicationContext, "Please enter a valid code", Toast.LENGTH_LONG)
                .show()
        } else {
            val i = Intent(this, DriverDashboard::class.java)
            startActivity(i)
        }
        val code = pin.text!!.map { it.toInt() }
    }

}