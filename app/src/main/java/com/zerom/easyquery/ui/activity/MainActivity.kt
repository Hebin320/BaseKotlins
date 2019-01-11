package com.zerom.easyquery.ui.activity

import android.os.Bundle
import com.zerom.easyquery.R
import com.zerom.easyquery.base.BaseActivity
import com.zerom.easyquery.ui.activity.universal.DoMainActivity
import com.zerom.easyquery.ui.activity.universal.WebviewActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clTest.setOnClickListener { startActivity<DoMainActivity>() }
    }


}
