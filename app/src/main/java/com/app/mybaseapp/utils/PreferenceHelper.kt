package com.app.mybaseapp.utils

import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun saveString(key: String = PREFERENCE_DEFAULT_KEY, str: String) {
        sharedPreferences.edit().putString(key, str).apply()
    }

    fun getString(key: String = PREFERENCE_DEFAULT_KEY): String? {
        return sharedPreferences.getString(key, null)
    }

    fun saveInt(key: String = PREFERENCE_DEFAULT_KEY, int: Int) {
        sharedPreferences.edit().putInt(key, int).apply()
    }

    fun getInt(key: String = PREFERENCE_DEFAULT_KEY): Int {
        return sharedPreferences.getInt(key, Zero)
    }

    fun saveLong(key: String = PREFERENCE_DEFAULT_KEY, long: Long) {
        sharedPreferences.edit().putLong(key, long).apply()
    }

    fun getLong(key: String = PREFERENCE_DEFAULT_KEY): Long {
        return sharedPreferences.getLong(key, 0L)
    }


    fun saveBoolean(key: String = PREFERENCE_DEFAULT_KEY, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String = PREFERENCE_DEFAULT_KEY): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun saveFloat(key: String = PREFERENCE_DEFAULT_KEY, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String = PREFERENCE_DEFAULT_KEY): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

}