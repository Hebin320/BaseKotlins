@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.content.Context
import com.hebin.hxbr.util.BaseFile

/**
 *  保存信息到本地 ——> 类型、字符串
 * */
inline fun Context.saveFile(infoKey: String, info: String) = BaseFile.saveString(this, infoKey, info)

/**
 *  保存信息到本地 ——> 类型、字符串
 * */
inline fun Context.saveFile(localName: String, infoKey: String, info: String) = BaseFile.saveString(this, localName, infoKey, info)

/**
 *  保存信息到本地 ——> 类型、布尔值
 * */
inline fun Context.saveFile(infoKey: String, boolean: Boolean) = BaseFile.saveBoolean(this, infoKey, boolean)

/**
 *  保存信息到本地 ——> 类型、布尔值
 * */
inline fun Context.saveFile(localName: String, infoKey: String, boolean: Boolean) = BaseFile.saveBoolean(this, localName, infoKey, boolean)

/**
 *  保存信息到本地 ——> 类型、数字
 * */
inline fun Context.saveFile(infoKey: String, position: Int) = BaseFile.saveInt(this, infoKey, position)

/**
 *  保存信息到本地 ——> 类型、数字
 * */
inline fun Context.saveFile(localName: String, infoKey: String, position: Int) = BaseFile.saveInt(this, localName, infoKey, position)

/**
 *  读取本地保存的信息 ——> 类型、字符串
 * */
inline fun Context.loadString(infoKey: String) = BaseFile.loadString(this, infoKey)

/**
 *  读取本地保存的信息 ——> 类型、字符串
 * */
inline fun Context.loadString(localName: String, infoKey: String) = BaseFile.loadString(this, localName, infoKey)

/**
 *  读取本地保存的信息 ——> 类型、布尔值
 * */
inline fun Context.loadBoolean(infoKey: String) = BaseFile.loadBoolean(this, infoKey)

/**
 *  读取本地保存的信息 ——> 类型、布尔值
 * */
inline fun Context.loadBoolean(localName: String, infoKey: String) = BaseFile.loadBoolean(this, localName, infoKey)

/**
 *  读取本地保存的信息 ——> 类型、数字
 * */
inline fun Context.loadInt(infoKey: String) = BaseFile.loadInt(this, infoKey)

/**
 *  读取本地保存的信息 ——> 类型、数字
 * */
inline fun Context.loadInt(localName: String, infoKey: String) = BaseFile.loadInt(this, localName, infoKey)