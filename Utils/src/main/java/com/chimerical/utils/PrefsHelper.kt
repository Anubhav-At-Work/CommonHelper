package com.chimerical.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils

@SuppressLint("StaticFieldLeak")
object PrefsHelper {

    private lateinit var sharedPref: SharedPreferences
    private const val PREFS_NAME = "sharedPref"
    private lateinit var context: Context

   /* init {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }*/

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        PrefsHelper.context = context
    }

    fun getStringSharedPref(key: String): String? {
        return sharedPref.getString(key, null)
    }


    fun setStringSharedPref(key: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.apply {
            putString(key, value)
        }.apply()

    }

    fun getBooleanSharedPref(key: String): Boolean {
//        Timber.e("Object Boolean Status : ${sharedPref.getBoolean(key, false)}")
        return sharedPref.getBoolean(key, false)
    }

    fun setBooleanSharedPref(key: String, boolean: Boolean) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.apply {
            putBoolean(key, boolean)
        }.apply()

    }


    /**
     * Helper method to retrieve a float value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getFloatPreference(key: String?, defaultValue: Float): Float {
        return sharedPref.getFloat(key, defaultValue)
    }

    /**
     * Helper method to write a float value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setFloatPreference(key: String?, value: Float) {
        val editor = sharedPref.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    /**
     * Helper method to retrieve a long value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getLongPreference(key: String?, defaultValue: Long): Long {
        var value = defaultValue
        if (sharedPref != null) {
            value = sharedPref.getLong(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write a long value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setLongPreference(key: String?, value: Long) {
        if (sharedPref != null) {
            val editor = sharedPref.edit()
            editor.putLong(key, value)
            editor.apply()
        }
    }

    /**
     * Helper method to retrieve an integer value from [SharedPreferences].
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    fun getIntegerPreference(key: String?, defaultValue: Int): Int {
        var value = defaultValue
        if (sharedPref != null) {
            value = sharedPref.getInt(key, defaultValue)
        }
        return value
    }

    /**
     * Helper method to write an integer value to [SharedPreferences].
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    fun setIntegerPreference(key: String?, value: Int) {
        if (sharedPref != null) {
            val editor = sharedPref.edit()
            editor.putInt(key, value)
            editor.apply()
        }
    }

    fun clearSharedPref() {
        sharedPref.edit().clear().apply()
    }

    /**
     * Helper method to remove a key from [SharedPreferences].
     *
     * @param key
     * @return true if the new value was successfully written to persistent storage.
     */
    fun clearPreference(key: String?) {
        if (!TextUtils.isEmpty(key)) {
            val editor = sharedPref.edit()
            editor.remove(key)
            editor.apply()
        }
    }

    fun clear() {
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

}