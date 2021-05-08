package tech.codezit.gpsmonitoringforambulances

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        next.setOnClickListener {
            submit()
        }

        val requestCode  = 28
        // foreground only or targeting API level 28 and lower
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), requestCode)

        // All buttons click listeners

        driver_next.setOnClickListener { selection("driver") }
        user_next.setOnClickListener { selection("user") }
        track_next.setOnClickListener { selection("hospital") }

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onStart() {
        super.onStart()
        val requestCode = 29
        // foreground only or targeting API level 28 and lower
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), requestCode)
        // background and targeting API level 29 and higher
        ActivityCompat.requestPermissions(this, arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION), requestCode)
    }

    // Making sure only one option is selected while logging in
    fun selection(btn: String) {
        if (btn == "driver") {
            user_next.isChecked = false
            track_next.isChecked = false
        } else if (btn == "user") {
            track_next.isChecked = false
            driver_next.isChecked = false
        } else if (btn == "hospital") {
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
        } else if (track_next.isChecked) {
            startActivity(Intent(this, Hospital::class.java))
        } else {
            Toast.makeText(applicationContext, "Please make one choice", Toast.LENGTH_SHORT)
                .show()
        }
    }
}