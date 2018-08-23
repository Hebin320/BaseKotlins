package com.hebin.project.ui.activity.universal

import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import com.hebin.hxbr.*
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.hebin.project.base.BaseFile
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
        when (loadString(BaseFile.DOMAINTAG)) {
            "", "1" -> switchDomain.isChecked = true
            "2" -> switchTest.isChecked = true
            "3" -> switchLocal.isChecked = true
            "4" -> switchDev.isChecked = true
        }
        when (loadString(BaseFile.WEBDOMAINTAG)) {
            "", "1" -> switchWebDomain.isChecked = true
            "2" -> switchWebTest.isChecked = true
            "3" -> switchWebLocal.isChecked = true
            "4" -> switchWebDev.isChecked = true
        }
        when (loadString(BaseFile.FILEDOMAINTAG)) {
            "", "1" -> switchFileDomain.isChecked = true
            "2" -> switchFileTest.isChecked = true
            "3" -> switchFileLocal.isChecked = true
            "4" -> switchFileDev.isChecked = true
        }
        onClick()
        setText(arrayOf(etDomain, etTest, etLocal, etDev), arrayOf(switchDomain, switchTest, switchLocal, switchDev), BaseFile.DOMAIN,
                arrayOf(BaseFile.DOMAINTEXT, BaseFile.DOMAINTESTTEXT, BaseFile.DOMAINLOCALTEXT, BaseFile.DOMAINDEVTEXT))
        setText(arrayOf(etWebDomain, etWebTest, etWebLocal, etWebDev), arrayOf(switchWebDomain, switchWebTest, switchWebLocal, switchWebDev), BaseFile.WEBDOMAIN,
                arrayOf(BaseFile.WEBDOMAINTEXT, BaseFile.WEBDOMAINTESTTEXT, BaseFile.WEBDOMAINLOCALTEXT, BaseFile.WEBDOMAINDEVTEXT))
        setText(arrayOf(etFileDomain, etFileTest, etFileLocal, etFileDev), arrayOf(switchFileDomain, switchFileTest, switchFileLocal, switchFileDev), BaseFile.FILEDOMAIN,
                arrayOf(BaseFile.FILEDOMAINTEXT, BaseFile.FILEDOMAINTESTTEXT, BaseFile.FILEDOMAINLOCALTEXT, BaseFile.FILEDOMAINDEVTEXT))
        firstText(arrayOf(etDomain, etTest, etLocal, etDev), arrayOf(BaseFile.DOMAINTEXT, BaseFile.DOMAINTESTTEXT, BaseFile.DOMAINLOCALTEXT, BaseFile.DOMAINDEVTEXT),
                arrayOf("https://api.safetypla.com", "http://api.safetypla.cc", "http://api.safetypla.d", "http://api.safetypla.z"))
        firstText(arrayOf(etWebDomain, etWebTest, etWebLocal, etWebDev), arrayOf(BaseFile.WEBDOMAINTEXT, BaseFile.WEBDOMAINTESTTEXT, BaseFile.WEBDOMAINLOCALTEXT, BaseFile.WEBDOMAINDEVTEXT),
                arrayOf("https://m.safetypla.com", "http://m.safetypla.cc", "http://m.safetypla.d", "http://m.safetypla.z"))
        firstText(arrayOf(etFileDomain, etFileTest, etFileLocal, etFileDev), arrayOf(BaseFile.FILEDOMAINTEXT, BaseFile.FILEDOMAINTESTTEXT, BaseFile.FILEDOMAINLOCALTEXT, BaseFile.FILEDOMAINDEVTEXT),
                arrayOf("https://file.safetypla.com", "http://file.safetypla.cc", "http://file.safetypla.d", "http://flie.safetypla.z"))
        setSwitch(arrayOf(switchDomain, switchTest, switchLocal, switchDev), BaseFile.DOMAIN, BaseFile.DOMAINTAG,
                arrayOf(etDomain.getString(), etTest.getString(), etLocal.getString(), etDev.getString()),
                arrayOf("1", "2", "3", "4"))
        setSwitch(arrayOf(switchWebDomain, switchWebTest, switchWebLocal, switchWebDev), BaseFile.WEBDOMAIN, BaseFile.WEBDOMAINTAG,
                arrayOf(etWebDomain.getString(), etWebTest.getString(), etWebLocal.getString(), etWebDev.getString()),
                arrayOf("1", "2", "3", "4"))
        setSwitch(arrayOf(switchFileDomain, switchFileTest, switchFileLocal, switchFileDev), BaseFile.FILEDOMAIN, BaseFile.FILEDOMAINTAG,
                arrayOf(etFileDomain.getString(), etFileTest.getString(), etFileLocal.getString(), etFileDev.getString()),
                arrayOf("1", "2", "3", "4"))
    }

    fun onClick() {
        // 返回
        ivBack.setOnClickListener { finish() }
    }

    private fun setSwitch(array: Array<Switch>, type: String, typeTAG: String, string: Array<String>, tag: Array<String>) {
        for (i in array.indices) {
            val finalI = i
            array[i].isCheck {
                saveFile(type, string[i])
                saveFile(typeTAG, tag[i])
                for (k in array.indices) {
                    if (k != finalI) {
                        array[k].isChecked = false
                    }
                }
            }
        }
    }

    private fun setText(array: Array<EditText>, switch: Array<Switch>, tag: String, type: Array<String>) {
        for (i in array.indices) {
            array[i].addTextChangedListener {
                saveFile(type[i], array[i].getString())
                if (switch[i].isChecked) {
                    saveFile(tag, array[i].getString())
                }
            }
        }
    }

    private fun firstText(array: Array<EditText>, type: Array<String>, url: Array<String>) {
        for (i in array.indices) {
            if (loadString(type[i]).isEmpty()) {
                array[i].texts = url[i]
            } else {
                array[i].texts = loadString(type[i])
            }
        }
    }
}
