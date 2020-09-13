package tech.codezit.gpsmonitoringforambulances

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore

class HospitalList : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_list)
    }

    fun goToInfo(view: View) {
        val i = Intent(this, HospitalInfo::class.java)
        startActivity(i)
    }

}