package tech.codezit.gpsmonitoringforambulances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.text.set
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_hospital_dashboard.*

class HospitalDashboard : AppCompatActivity() {

    private var code: Int = 0
    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_dashboard)

        // Retrieving data from the intent
        code = intent.getIntExtra("hospital_code", 0)

        update.setOnClickListener {
            upload()
        }
    }

    override fun onStart() {
        super.onStart()
        val uid = code.toString()
        val hospitalRef = db.collection("hospitals")
            .document(uid)

        hospitalRef.get()
            .addOnSuccessListener {
                if (it != null) {
                    hospital_name.text = it.getString("hospital_name")
                    gmap_url.setText(it.getString("gmap_url"))
                    total_beds.setText(it.getString("total_beds"))
                    vacant_beds.setText(it.getString("vacant_beds"))
                    phone_number.setText(it.getString("phone"))
                    Log.d("HOSPITAL DATA", "${it.data}")
                } else {
                    Log.d("HOSPITAL DATA", "No such document found!")
                }
            }
    }

    private fun upload() {
        // Upload the data to Google Cloud Datastore
        val uid = code.toString()
        val totalBeds = total_beds.text.toString().toInt()
        val vacantBeds = vacant_beds.text.toString().toInt()
        val phoneNumber = phone_number.text.toString()
        val gMap = gmap_url.text.toString()

        // Updating data
        val hospitalRef = db.collection("hospitals")
            .document(uid)

        hospitalRef.update("gmap_url", gMap)
        hospitalRef.update("phone", phoneNumber)
        hospitalRef.update("vacant_beds", vacantBeds)
        hospitalRef.update("total_beds", totalBeds)


    }

}