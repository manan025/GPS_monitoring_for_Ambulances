package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_hospital.*
import kotlinx.android.synthetic.main.activity_hospital_dashboard.*

class Hospital : AppCompatActivity() {

    private var db =FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)
        hospital_reg.setOnClickListener { next() }
    }

    fun next() {
        // Make sure the pin is valid
        if (pin.text!!.length < 4) {
            Toast.makeText(applicationContext, "Please enter a valid hospital pin!", Toast.LENGTH_SHORT)
                .show()
        } else {

            val hospitalRef = db.collection("hospitals")
                .document(pin.text.toString())

            hospitalRef.get()
                .addOnSuccessListener {
                    if (it != null) {
                        val hospital_code = Integer.valueOf(pin.text.toString())
                        val i = Intent(this, HospitalDashboard::class.java)
                        i.putExtra("hospital_code", hospital_code)
                        startActivity(i)
                    } else {
                        Toast.makeText(applicationContext, "recheck your pin", Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }
    }
}