package com.hebin.project.ui.universal

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.widget.LinearLayout
import com.hebin.project.R
import com.just.library.AgentWeb
import com.just.library.ChromeClientCallbackManager
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.public_simple_title.*


class WebviewActivity : AppCompatActivity(), ChromeClientCallbackManager.ReceivedTitleCallback {

    var mAgentWeb: AgentWeb? = null
    var webview: WebView? = null

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
                .useDefaultIndicator()// 使用默认进度条
                .setIndicatorColorWithHeight(Color.parseColor("#00A6FF"), 4)
                .setReceivedTitleCallback(this)
                .createAgentWeb()
                .ready()
                .go("http://www.jd.com")
        webview = mAgentWeb?.webCreator?.get()
    }

    override fun onReceivedTitle(p0: WebView?, p1: String?) {
        tvTitle.text = p1
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
