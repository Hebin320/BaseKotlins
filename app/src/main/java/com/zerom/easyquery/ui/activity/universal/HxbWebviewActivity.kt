package com.zerom.easyquery.ui.activity.universal

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import com.tencent.smtt.export.external.interfaces.SslError
import com.tencent.smtt.export.external.interfaces.SslErrorHandler
import com.tencent.smtt.sdk.CookieManager
import com.tencent.smtt.sdk.CookieSyncManager
import com.tencent.smtt.sdk.WebViewClient
import com.zerom.easyquery.R
import com.zerom.easyquery.anko.hideDialog
import com.zerom.easyquery.anko.showDialog
import com.zerom.easyquery.base.BaseActivity
import kotlinx.android.synthetic.main.activity_hxb_webview.*
import kotlinx.android.synthetic.main.public_simple_title_right_img_text.*

@Suppress("DEPRECATION")
open class HxbWebviewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hxb_webview)
        webNature()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webNature() {
        //自适应屏幕高宽
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        //设置 缓存模式
        webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        webView.settings.databaseEnabled = true
        val dir = this.applicationContext.getDir("database", Context.MODE_PRIVATE).path
        webView.settings.setGeolocationEnabled(true)
        webView.settings.setGeolocationDatabasePath(dir)
        webView.settings.domStorageEnabled = true
        webView.settings.builtInZoomControls = true
        webView.settings.javaScriptEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.setAllowFileAccessFromFileURLs(true)
        webView.settings.setAllowUniversalAccessFromFileURLs(true)
        // 设置允许JS弹窗
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: com.tencent.smtt.sdk.WebView?, url: String?): Boolean {
                Log.e("Hebin", url)
                if (url!!.startsWith("tel:")) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                    return true
                } else if (url.contains("alipays://platformapi")) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                    return true
                } else if (url.contains("/close/js/html")) {
                    finish()
                    return true
                } else if (url.startsWith("http:") || url.startsWith("https:")) {
                    view!!.loadUrl(url)
                    return true
                }
                return false
            }

            override fun onReceivedSslError(p0: com.tencent.smtt.sdk.WebView?, p1: SslErrorHandler?, p2: SslError?) {
                super.onReceivedSslError(p0, p1, p2)
                p1?.proceed()
            }

            override fun onPageStarted(p0: com.tencent.smtt.sdk.WebView?, p1: String?, p2: Bitmap?) {
                super.onPageStarted(p0, p1, p2)
                showDialog()
            }

            override fun onPageFinished(view: com.tencent.smtt.sdk.WebView?, url: String?) {
                if (!webView.settings.loadsImagesAutomatically) {
                    webView.settings.loadsImagesAutomatically = true
                }
                hideDialog()
            }
        }

        webView.settings.loadsImagesAutomatically = Build.VERSION.SDK_INT >= 19
        webView.webChromeClient = object : com.tencent.smtt.sdk.WebChromeClient() {
            override fun onReceivedTitle(p0: com.tencent.smtt.sdk.WebView?, title: String?) {
                super.onReceivedTitle(p0, title)
                if (title != null)
                    tvTitle.text = title
            }
        }

        webView.setDownloadListener { url, _, _, _, _ ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //清空所有Cookie
        CookieSyncManager.createInstance(context)  //Create a singleton CookieSyncManager within a context
        val cookieManager = CookieManager.getInstance() // the singleton CookieManager instance
        cookieManager.removeAllCookie()// Removes all cookies.
        CookieSyncManager.getInstance().sync() // forces sync manager to sync now
        webView.webChromeClient = null
        webView.webViewClient = null
        webView.settings.javaScriptEnabled = false
        webView.clearCache(true)
    }
}
