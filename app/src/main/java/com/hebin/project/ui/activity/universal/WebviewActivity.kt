package com.hebin.project.ui.activity.universal

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import com.hebin.project.R
import com.hebin.project.anko.hideLoad
import com.hebin.project.anko.showLoad
import com.hebin.project.base.BaseActivity
import com.tencent.smtt.sdk.ValueCallback
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.public_simple_title.*


class WebviewActivity : BaseActivity() {

    private var mUploadMessage: ValueCallback<Uri>? = null
    private var mUploadMessageForAndroid5: ValueCallback<Array<Uri>>? = null
    private val FILECHOOSER_RESULTCODE = 1
    private val FILECHOOSER_RESULTCODE_FOR_ANDROID_5 = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        // 浏览器加载网页
        webNature()
        // 设置返回点击、标题等
        init()
    }


    private fun init() {
        ivBack.setOnClickListener { onBackPressed() }
        showLoad()
        webView.loadUrl("http://www.baidu.com")
    }

    /**
     * webview的各种属性
     */

    fun webNature() {
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url!!.startsWith("tel:")) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                } else if (url.contains("alipays://platformapi")) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                } else if (url.startsWith("http:") || url.startsWith("https:")) {
                    view!!.loadUrl(url)
                }
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                if (!webView.settings.loadsImagesAutomatically) {
                    webView.settings.loadsImagesAutomatically = true
                }
                hideLoad()
            }
        })

        webView.settings.loadsImagesAutomatically = Build.VERSION.SDK_INT >= 19

        webView.setWebChromeClient(object : WebChromeClient() {
            //扩展浏览器上传文件
            //3.0++版本
            fun openFileChooser(uploadMsg: ValueCallback<Uri>, acceptType: String) {
                openFileChooserImpl(uploadMsg)
            }

            //3.0--版本
            fun openFileChooser(uploadMsg: ValueCallback<Uri>) {
                openFileChooserImpl(uploadMsg)
            }

            override fun openFileChooser(valueCallback: ValueCallback<Uri>, s: String?, s1: String?) {
                openFileChooserImpl(valueCallback)
            }

            override fun onShowFileChooser(webView: WebView?, valueCallback: ValueCallback<Array<Uri>>?, fileChooserParams: WebChromeClient.FileChooserParams?): Boolean {
                openFileChooserImplForAndroid5(valueCallback!!)
                return true
            }

            override fun onReceivedTitle(p0: WebView?, title: String?) {
                super.onReceivedTitle(p0, title)
                if (title != null)
                    tvTitle.text = title
            }
        })
    }

    private fun openFileChooserImpl(uploadMsg: ValueCallback<Uri>) {
        mUploadMessage = uploadMsg
        val i = Intent(Intent.ACTION_GET_CONTENT)
        i.addCategory(Intent.CATEGORY_OPENABLE)
        i.type = "image/*"
        startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE)
    }

    private fun openFileChooserImplForAndroid5(uploadMsg: ValueCallback<Array<Uri>>) {
        mUploadMessageForAndroid5 = uploadMsg
        val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
        contentSelectionIntent.type = "image/*"
        val chooserIntent = Intent(Intent.ACTION_CHOOSER)
        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
        chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")

        startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE_FOR_ANDROID_5)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent) {
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage)
                return
            val result = if (resultCode != Activity.RESULT_OK) null else intent.data
            mUploadMessage!!.onReceiveValue(result)
            mUploadMessage = null

        } else if (requestCode == FILECHOOSER_RESULTCODE_FOR_ANDROID_5) {
            if (null == mUploadMessageForAndroid5)
                return
            val result = if (resultCode != Activity.RESULT_OK) null else intent.data
            if (result != null) {
                mUploadMessageForAndroid5!!.onReceiveValue(arrayOf(result))
            } else {
                mUploadMessageForAndroid5!!.onReceiveValue(arrayOf())
            }
            mUploadMessageForAndroid5 = null
        }
    }


    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}
