package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_driver.*

class DriverDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_dashboard)
    }

    fun loadHospital(view: View) {
        val i = Intent(this, HospitalList::class.java)
        startActivity(i)
    }

    fun loadSite(view: View) {
        val i = Intent(this, webView::class.java)
        i.putExtra("tracking_url", "https://www.google.com/maps/dir/Patliputra+Medical+College,+Kusum+Vihar,+Koyla+Nagar,+Dhanbad,+Jharkhand/23.8310824,86.5573221/@23.8222863,86.474211,13z/data=!3m1!4b1!4m9!4m8!1m5!1m1!1s0x39f6bcbeeeed355b:0x1be78824b4fa5a24!2m2!1d86.4624047!2d23.8086527!1m0!3e0")
        startActivity(i)
    }

    fun covidDashboard(view: View) {
        val i = Intent(this, User::class.java)
        startActivity(i)
    }

}