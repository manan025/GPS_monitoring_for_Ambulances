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
        help_layout.visibility = View.INVISIBLE
        covid_details.visibility = View.INVISIBLE
    }

    fun contactDoctor(view: View) {
        // Start intent to Zoom meeting [TESTING PHASE]
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://narayanagroup.zoom.us/j/9949306210?pwd=TTNMb3BEREFMYTdRWGlJZkxEQ2t4QT09"))
        startActivity(browserIntent)
    }

    fun help(view: View) {
        before_help.visibility = View.INVISIBLE
        after_book.visibility = View.INVISIBLE
        covid_details.visibility = View.INVISIBLE
        help_layout.visibility = View.VISIBLE
    }

    fun showDetails(view: View) {
        before_help.visibility = View.INVISIBLE
        after_book.visibility = View.INVISIBLE
        help_layout.visibility = View.INVISIBLE
        covid_details.visibility = View.VISIBLE
    }

    fun trackAmbulance(view: View) {
        val i = Intent(this, webView::class.java)
        i.putExtra("tracking_url", "https://www.google.com/maps/dir/23.8310824,86.5573221/Patliputra+Medical+College,+Kusum+Vihar,+Koyla+Nagar,+Dhanbad,+Jharkhand/@23.8222374,86.474211,13z/data=!3m1!4b1!4m9!4m8!1m0!1m5!1m1!1s0x39f6bcbeeeed355b:0x1be78824b4fa5a24!2m2!1d86.4624047!2d23.8086527!3e0")
        startActivity(i)
    }

    fun beds(view: View) {
        val i = Intent(this, HospitalList::class.java)
        startActivity(i)
    }

}