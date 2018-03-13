package com.hebin.project.utils

import android.annotation.TargetApi
import android.content.Context
import android.media.AudioManager
import android.os.Build

/**
 * ========================================
 *
 *
 * 版 权：深圳市晶网科技控股有限公司 版权所有 （C） 2015
 *
 *
 * 作 者：陈冠明
 *
 *
 * 个人网站：http://www.dou361.com
 *
 *
 * 版 本：1.0
 *
 *
 * 创建日期：2015/12/8
 *
 *
 * 描 述：多媒体工具类
 *
 *
 *
 *
 * 修订历史：
 *
 *
 * ========================================
 */
class MediaUtils private constructor() {

    init {
        throw UnsupportedOperationException("cannot be instantiated")
    }

    companion object {

        /**
         * @param bMute 值为true时为关闭背景音乐。
         */
        @TargetApi(Build.VERSION_CODES.FROYO)
        fun muteAudioFocus(context: Context, bMute: Boolean): Boolean {
            var bool = false
            val am = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
            if (bMute) {
                val result = am.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
                bool = result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
            } else {
                val result = am.abandonAudioFocus(null)
                bool = result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED
            }
            return bool
        }
    }
}