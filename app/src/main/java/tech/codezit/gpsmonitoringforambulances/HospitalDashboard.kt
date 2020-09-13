package tech.codezit.gpsmonitoringforambulances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_hospital_dashboard.*

class HospitalDashboard : AppCompatActivity() {

    private var code: Int = 0
    private var db = FirebaseFirestore.getInstance()

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

                    val total = it.getLong("total_beds")!!.toInt().toString()
                    total_beds_text.setText(total)

                    val vacant = it.getLong("vacant_beds")!!.toInt().toString()
                    vacant_beds_text.setText(vacant)

                    phone_number.setText(it.getString("phone"))
                    Log.d("HOSPITAL DATA", "${it.data}")
                } else {
                    Log.d("HOSPITAL DATA", "No such document found!")
                }
            }
    }

    private fun upload() {
        // Upload the data to Google Cloud FireStore
        val uid = code.toString()
        val totalBeds = total_beds_text.text.toString().toInt()
        val vacantBeds = vacant_beds_text.text.toString().toInt()
        val phoneNumber = phone_number.text.toString()
        val gMap = gmap_url.text.toString()

        // Updating data
        val hospitalRef = db.collection("hospitals")
            .document(uid)

        hospitalRef.update("gmap_url", gMap)
        hospitalRef.update("phone", phoneNumber)
        hospitalRef.update("vacant_beds", vacantBeds)
        hospitalRef.update("total_beds", totalBeds)


        Toast.makeText(applicationContext, "UPLOADED DATA", Toast.LENGTH_SHORT).show()
    }

}