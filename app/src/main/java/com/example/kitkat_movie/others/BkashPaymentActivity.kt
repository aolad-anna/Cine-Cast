package com.example.kitkat_movie.others

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.kitkat_movie.R
import com.example.kitkat_movie.model.BkashPaymentRequest
import com.example.kitkat_movie.onboarding.NavBar
import com.example.kitkat_movie.utils.JSInterface
import com.google.gson.Gson


class BkashPaymentActivity : AppCompatActivity() {

    private var paymentRequest = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bkash_payment)


        val pButton = findViewById<View>(R.id.imageView822) as ImageView
        pButton.setOnClickListener {
            super.onBackPressed();
        }

        val HButton = findViewById<View>(R.id.imageView722) as ImageView
        HButton.setOnClickListener { view ->
            val intent = Intent(view.context, NavBar::class.java)
            view.context.startActivity(intent)
        }

        val request = BkashPaymentRequest(intent.getStringExtra("amount"), intent.getStringExtra("intent"))
        paymentRequest = "{paymentRequest:${Gson().toJson(request)}}"

        initBkashWebView()
        initBkashWebViewClient(paymentRequest)
    }

    private fun initBkashWebView() {
        val webView = findViewById<WebView>(R.id.bkashWebView)
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setAppCacheEnabled(false)
            cacheMode = WebSettings.LOAD_NO_CACHE
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        webView.apply {
            clearCache(true)
            isFocusableInTouchMode = true
            webView.addJavascriptInterface(JSInterface(this@BkashPaymentActivity), "AndroidNative")
            loadUrl("file:///android_asset/www/checkout_120.html")
        }
    }

    private fun initBkashWebViewClient(paymentRequest: String) {
        val webView = findViewById<WebView>(R.id.bkashWebView)
        webView.webViewClient = object : WebViewClient(){

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError?) {
                handler.proceed()
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                val Progress = findViewById<ProgressBar>(R.id.loadingProgressBar)
                Progress.visibility = VISIBLE
                if (url == "https://www.bkash.com/terms-and-conditions") {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    return true
                }
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                val Progress = findViewById<ProgressBar>(R.id.loadingProgressBar)
                Progress.visibility = VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                val webView = findViewById<WebView>(R.id.bkashWebView)
                webView.let {
                    it.loadUrl("javascript:callReconfigure($paymentRequest )")
                    it.loadUrl("javascript:clickPayButton()")
                }
                val Progress = findViewById<ProgressBar>(R.id.loadingProgressBar)
                Progress.visibility = GONE
            }
        }
    }

}