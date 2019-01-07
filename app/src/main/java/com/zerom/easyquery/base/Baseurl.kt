package com.zerom.easyquery.base

import android.content.Context
import android.util.Log
import com.zerom.easyquery.anko.loadString
import com.zerom.easyquery.anko.prinString

/**
 * Author Hebin
 * <p>
 * created at 2018/4/9 15:59
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：APP中用到的所有的网址的集合
 */
class Baseurl {

    companion object {

        private fun getDoMain(context: Context): String {
            return if (context.loadString(BaseFile.DOMAIN) == "") {
                "https://api.safetypla.com"
            } else {
                context.loadString(BaseFile.DOMAIN)
            }
        }

        private fun getWebDomain(context: Context): String {
            return if (context.loadString(BaseFile.WEBDOMAIN) == "") {
                "https://m.safetypla.com"
            } else {
                context.loadString(BaseFile.WEBDOMAIN)
            }
        }

        private fun getFileDomain(context: Context): String {
            return if (context.loadString(BaseFile.FILEDOMAIN) == "") {
                "https://file.safetypla.com"
            } else {
                context.loadString(BaseFile.FILEDOMAIN)
            }
        }




    }
}
