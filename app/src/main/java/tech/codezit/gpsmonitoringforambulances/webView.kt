package tech.codezit.gpsmonitoringforambulances

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class webView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val i = intent.getStringExtra("tracking_url")

        siteLoader.settings.javaScriptEnabled = true
        siteLoader.loadUrl(i)
    }
}