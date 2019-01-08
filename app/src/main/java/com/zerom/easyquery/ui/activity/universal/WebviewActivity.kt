package com.zerom.easyquery.ui.activity.universal

import android.os.Bundle
import com.zerom.easyquery.anko.getStringArrayExtra
import com.zerom.easyquery.anko.printLog
import kotlinx.android.synthetic.main.activity_hxb_webview.*

class WebviewActivity : HxbWebviewActivity() {

    companion object {
        const val INTENT_URL = "INTENT_URL"
    }

    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        webView.loadUrl(url)
    }

}
