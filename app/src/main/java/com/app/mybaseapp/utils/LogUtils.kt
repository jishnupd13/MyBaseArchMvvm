package com.app.mybaseapp.utils

/**
 *  for debugging and logging purpose ...
 *  logging is restricted for production version ...
 * */

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import com.app.mybaseapp.BuildConfig

fun Activity.errorLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.e(this::class.java.simpleName, message)
}

fun Activity.debugLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.d(this::class.java.simpleName, message)
}

fun Activity.infoLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.i(this::class.java.simpleName, message)
}

fun Activity.warningLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.w(this::class.java.simpleName, message)
}

fun Fragment.errorLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.e(this::class.java.simpleName, message)
}

fun Fragment.debugLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.d(this::class.java.simpleName, message)
}

fun Fragment.infoLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.i(this::class.java.simpleName, message)
}

fun Fragment.warningLog(message: String) {
    if (BuildConfig.DEBUG)
        Log.w(this::class.java.simpleName, message)
}