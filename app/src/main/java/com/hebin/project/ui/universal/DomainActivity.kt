package com.hebin.project.ui.universal

import android.os.Bundle
import android.widget.Switch
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.taorouw.base.BaseFile
import com.hebin.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_domain.*
import kotlinx.android.synthetic.main.public_simple_title.*

class DomainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_domain)
        init()
    }


    private fun init() {
        tvTitle.text = "设置域名"
        when (BaseFile.loadString(context, BaseFile.DOMAIN)) {
            "", "domain" -> switchDomain.isChecked = true
            "test" -> switchTest.isChecked = true
            else -> {
                switchDomain.isChecked = false
                switchTest.isChecked = false
            }
        }
        when (BaseFile.loadString(context, BaseFile.WEBDOMAIN)) {
            "", "domain" -> switchWebDomain.isChecked = true
            "test" -> switchWebTest.isChecked = true
            else -> {
                switchWebDomain.isChecked = false
                switchWebTest.isChecked = false
            }
        }
        onClick()
        setSwitch(arrayOf(switchDomain, switchTest), BaseFile.DOMAIN, arrayOf("domain", "test"))
        setSwitch(arrayOf(switchWebDomain, switchWebTest), BaseFile.WEBDOMAIN, arrayOf("domain", "test"))
    }

    private fun onClick() {
        // 返回
        ivBack.setOnClickListener { finish() }
        // 自定义域名
        tvSure.setOnClickListener {
            if (etDomain.text.isNotEmpty()) {
                BaseFile.saveString(context, BaseFile.DOMAIN, etDomain.text.toString())
                switchDomain.isChecked = false
                switchTest.isChecked = false
                ToastUtil.showToast(context, "设置成功")
            }
        }
        // 自定义web域名
        tvWebSure.setOnClickListener {
            if (etWebDomain.text.isNotEmpty()) {
                BaseFile.saveString(context, BaseFile.WEBDOMAIN, etWebDomain.text.toString())
                switchWebDomain.isChecked = false
                switchWebTest.isChecked = false
                ToastUtil.showToast(context, "设置成功")
            }
        }
    }

    private fun setSwitch(array: Array<Switch>, type: String, string: Array<String>) {
        for (i in array.indices) {
            val finalI = i
            array[i].setOnCheckedChangeListener { _, isCheck ->
                if (isCheck) {
                    for (k in array.indices) {
                        if (k == finalI) {
                            BaseFile.saveString(context, type, string[i])
                        } else {
                            array[k].isChecked = false
                        }
                    }
                }
            }
        }
    }
}
