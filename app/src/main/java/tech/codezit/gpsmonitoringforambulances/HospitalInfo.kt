package tech.codezit.gpsmonitoringforambulances

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_hospital_dashboard.*
import kotlinx.android.synthetic.main.activity_hospital_info.*
import kotlinx.android.synthetic.main.activity_hospital_info.hospital_name
import kotlinx.android.synthetic.main.activity_hospital_info.phone_number

class HospitalInfo : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var phone: String
    private lateinit var nav: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_info)
        val message = intent.extras
        if (message != null) {
            val code = message.get("code").toString()
            getHospitalDetails(code)
        }
        call_hospital.setOnClickListener { checkPermission() }
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Make a dialog asking to grant permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CALL_PHONE
                )
            ) {
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    42
                )
            }
        } else {
            callHospital()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        if (requestCode == 42) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                callHospital()
            } else {
                // TODO: Make a dialog that will ultimately say that the user can't call from the app.
            }
            return
        }
    }

    private fun getHospitalDetails(code: String) {
        val hp = db.collection("hospitals").document(code)
        hp.get()
            .addOnSuccessListener {
                if (it != null) {
                    hospital_name.text = it.get("hospital_name").toString()
                    total_beds.text = it.get("total_beds").toString()
                    vacant_beds.text = it.get("vacant_beds").toString()
                    phone_number.text = it.get("phone").toString()
                    phone = it.get("phone").toString()
                    nav = it.get("gmap_url").toString()

                } else {
                    Toast.makeText(applicationContext, "Hospital not found", Toast.LENGTH_LONG)
                        .show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(applicationContext, "Error: $it", Toast.LENGTH_LONG).show()
            }
    }

    fun callHospital() {
        startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:$phone")))
    }
}