package tech.codezit.gpsmonitoringforambulances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
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

}