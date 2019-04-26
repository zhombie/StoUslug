package services.alidesign.kz.stouslug

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import services.alidesign.kz.stouslug.Constants.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() = with(webView) {
        settings.javaScriptEnabled = true
        settings.builtInZoomControls = false
        settings.domStorageEnabled = true
        scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
        overScrollMode = WebView.OVER_SCROLL_NEVER
        webViewClient = WebViewClient()

        loadUrl(URL)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

}