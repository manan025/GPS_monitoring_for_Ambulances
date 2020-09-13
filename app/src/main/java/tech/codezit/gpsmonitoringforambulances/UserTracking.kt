package tech.codezit.gpsmonitoringforambulances

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import io.radar.sdk.Radar
import io.radar.sdk.RadarReceiver
import io.radar.sdk.RadarTrackingOptions

class UserTracking : AppCompatActivity() {

    val pb = "prj_test_pk_5f78e085e4c5f4b61655cc6046b3413c4ba28d79"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_tracking)

        Radar.initialize(this, pb)
        Radar.setUserId("Test_User")

        val requestCode = 1
        // foreground only or targeting API level 28 and lower
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), requestCode)

        // background and targeting API level 29 and higher
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION), requestCode)

        // continuous tracking
        Radar.startTracking(RadarTrackingOptions.CONTINUOUS)
    }
}