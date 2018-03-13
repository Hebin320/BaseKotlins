package com.hebin.utils

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.util.Log
import junit.framework.Assert
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

object Mutil {

    private val TAG = "SDK_Sample.Util"

    fun bmpToByteArray(bmp: Bitmap, needRecycle: Boolean): ByteArray {
        val output = ByteArrayOutputStream()
        bmp.compress(CompressFormat.PNG, 100, output)
        if (needRecycle) {
            bmp.recycle()
        }

        val result = output.toByteArray()
        try {
            output.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    fun getHtmlByteArray(url: String): ByteArray {
        var htmlUrl: URL? = null
        var inStream: InputStream? = null
        try {
            htmlUrl = URL(url)
            val connection = htmlUrl.openConnection()
            val httpConnection = connection as HttpURLConnection
            val responseCode = httpConnection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inStream = httpConnection.inputStream
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return inputStreamToByte(inStream!!)!!
    }

    fun inputStreamToByte(mIs: InputStream): ByteArray? {
        try {
            val bytestream = ByteArrayOutputStream()
            while (mIs.read() != -1) {
                bytestream.write(mIs.read())
            }
            val imgdata = bytestream.toByteArray()
            bytestream.close()
            return imgdata
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun readFromFile(fileName: String?, offset: Int, len: Int): ByteArray? {
        var len = len
        if (fileName == null) {
            return null
        }

        val file = File(fileName)
        if (!file.exists()) {
            Log.i(TAG, "readFromFile: file not found")
            return null
        }

        if (len == -1) {
            len = file.length().toInt()
        }

        Log.d(TAG, "readFromFile : offset = " + offset + " len = " + len + " offset + len = " + (offset + len))

        if (offset < 0) {
            Log.e(TAG, "readFromFile invalid offset:" + offset)
            return null
        }
        if (len <= 0) {
            Log.e(TAG, "readFromFile invalid len:" + len)
            return null
        }
        if (offset + len > file.length().toInt()) {
            Log.e(TAG, "readFromFile invalid file len:" + file.length())
            return null
        }

        var b: ByteArray? = null
        try {
            val `in` = RandomAccessFile(fileName, "r")
            b = ByteArray(len)
            `in`.seek(offset.toLong())
            `in`.readFully(b)
            `in`.close()

        } catch (e: Exception) {
            Log.e(TAG, "readFromFile : errMsg = " + e.message)
            e.printStackTrace()
        }

        return b
    }

    private val MAX_DECODE_PICTURE_SIZE = 1920 * 1440
    fun extractThumbNail(path: String?, height: Int, width: Int, crop: Boolean): Bitmap? {
        Assert.assertTrue(path != null && path != "" && height > 0 && width > 0)

        var options: BitmapFactory.Options? = BitmapFactory.Options()

        try {
            options!!.inJustDecodeBounds = true
            var tmp: Bitmap? = BitmapFactory.decodeFile(path, options)
            if (tmp != null) {
                tmp.recycle()
                tmp = null
            }

            Log.d(TAG, "extractThumbNail: round=" + width + "x" + height + ", crop=" + crop)
            val beY = options.outHeight * 1.0 / height
            val beX = options.outWidth * 1.0 / width
            Log.d(TAG, "extractThumbNail: extract beX = $beX, beY = $beY")
            options.inSampleSize = (if (crop) if (beY > beX) beX else beY else if (beY < beX) beX else beY).toInt()
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1
            }

            // NOTE: out of memory error
            while (options.outHeight * options.outWidth / options.inSampleSize > MAX_DECODE_PICTURE_SIZE) {
                options.inSampleSize++
            }

            var newHeight = height
            var newWidth = width
            if (crop) {
                if (beY > beX) {
                    newHeight = (newWidth.toDouble() * 1.0 * options.outHeight.toDouble() / options.outWidth).toInt()
                } else {
                    newWidth = (newHeight.toDouble() * 1.0 * options.outWidth.toDouble() / options.outHeight).toInt()
                }
            } else {
                if (beY < beX) {
                    newHeight = (newWidth.toDouble() * 1.0 * options.outHeight.toDouble() / options.outWidth).toInt()
                } else {
                    newWidth = (newHeight.toDouble() * 1.0 * options.outWidth.toDouble() / options.outHeight).toInt()
                }
            }

            options.inJustDecodeBounds = false

            Log.i(TAG, "bitmap required size=" + newWidth + "x" + newHeight + ", orig=" + options.outWidth + "x" + options.outHeight + ", sample=" + options.inSampleSize)
            var bm: Bitmap? = BitmapFactory.decodeFile(path, options)
            if (bm == null) {
                Log.e(TAG, "bitmap decode failed")
                return null
            }

            Log.i(TAG, "bitmap decoded size=" + bm.width + "x" + bm.height)
            val scale = Bitmap.createScaledBitmap(bm, newWidth, newHeight, true)
            if (scale != null) {
                bm.recycle()
                bm = scale
            }

            if (crop) {
                val cropped = Bitmap.createBitmap(bm, bm.width - width shr 1, bm.height - height shr 1, width, height) ?: return bm

                bm.recycle()
                bm = cropped
                Log.i(TAG, "bitmap croped size=" + bm.width + "x" + bm.height)
            }
            return bm

        } catch (e: OutOfMemoryError) {
            Log.e(TAG, "decode bitmap failed: " + e.message)
            options = null
        }

        return null
    }
}
