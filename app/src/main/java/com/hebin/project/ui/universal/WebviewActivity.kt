package com.hebin.project.ui.universal

import android.graphics.Color
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.LinearLayout
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.just.agentweb.AgentWeb
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.public_simple_title.*


class WebviewActivity : BaseActivity(){

   private var mAgentWeb: AgentWeb? = null
   private var webview: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        // 设置返回点击、标题等
        init()
        // 浏览器加载网页
        loadUrl()
    }

    private fun init() {
        ivBack.setOnClickListener { goBack() }

    }

    private fun loadUrl() {
        mAgentWeb = AgentWeb.with(this)//传入Activity
                .setAgentWebParent(llWebviewActivity, LinearLayout.LayoutParams(-1, -1))
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator(Color.parseColor("#00A6FF"), 4)// 使用默认进度条
                .setWebChromeClient(mWebChromeClient)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go("http://www.jd.com")
        webview = mAgentWeb?.webCreator?.webView
        webview?.settings?.setSupportZoom(true)
        // 设置出现缩放工具
        webview?.settings?.builtInZoomControls = true
        //扩大比例的缩放
        webview?.settings?.useWideViewPort = true
        //自适应屏幕
        webview?.settings?.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        webview?.settings?.loadWithOverviewMode = true
    }


    private val mWebChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            //do you work
            //            Log.i("Info","onProgress:"+newProgress);
        }

        override fun onReceivedTitle(view: WebView, title: String) {
            super.onReceivedTitle(view, title)
            tvTitle.text = title
        }
    }

    private fun goBack() {
        if (webview?.canGoBack()!!) {
            webview?.goBack()
        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        goBack()
    }

    override fun onPause() {
        mAgentWeb?.webLifeCycle?.onPause()
        super.onPause()

    }

    override fun onResume() {
        mAgentWeb?.webLifeCycle?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        mAgentWeb?.webLifeCycle?.onDestroy()
        super.onDestroy()
    }

}
