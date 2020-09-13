package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user.*


class User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }

    fun book(view: View) {
        before_help.visibility = View.INVISIBLE
        after_book.visibility = View.VISIBLE
    }

    fun contactDoctor(view: View) {
        // Start intent to Zoom meeting [TESTING PHASE]
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://narayanagroup.zoom.us/j/9949306210?pwd=TTNMb3BEREFMYTdRWGlJZkxEQ2t4QT09"))
        startActivity(browserIntent)
    }

    fun help(view: View) {
        before_help.visibility = View.INVISIBLE
        after_book.visibility = View.INVISIBLE
        help_layout.visibility = View.VISIBLE
    }

}