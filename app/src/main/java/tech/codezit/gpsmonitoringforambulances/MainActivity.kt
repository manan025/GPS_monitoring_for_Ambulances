package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next.setOnClickListener {
            submit()
        }
    }

    // Making sure only one option is selected while logging in
    fun selection(view: View) {
        if (driver_next.isChecked) {
            user_next.isChecked = false
            track_next.isChecked = false
        } else if (user_next.isChecked) {
            track_next.isChecked = false
            driver_next.isChecked = false
        } else {
            user_next.isChecked = false
            driver_next.isChecked = false
        }
    }

    // On submitting, Go to the next activity accordingly.
    fun submit() {
        if (driver_next.isChecked) {
            startActivity(Intent(this, Driver::class.java))
        } else if (user_next.isChecked) {
            startActivity(Intent(this, User::class.java))
        } else {
            startActivity(Intent(this, Hospital::class.java))
        }
    }
}