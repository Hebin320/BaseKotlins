package com.hebin.project.utils

import android.annotation.TargetApi
import android.content.Context
import android.media.AudioManager
import android.os.Build

/**
 * Author Hebin
 * <p>
 * created at 2018/3/13 17:11
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
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