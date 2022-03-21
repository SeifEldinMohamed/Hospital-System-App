package com.seif.hospitalsystem.data.sharedPreference

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AppSharedPreference {
    companion object {
        private var mSharedPref: SharedPreferences? = null
        fun init(context: Context) {
            if (mSharedPref == null)
                mSharedPref = context.getSharedPreferences("appSharedPref", Activity.MODE_PRIVATE)
        }

        fun readSpecialization(key: String?, defValue: String): String {
            return mSharedPref!!.getString(key, defValue).toString()
        }

        fun writeSpecialization(key: String?, value: String) {
            val prefsEditor: SharedPreferences.Editor = mSharedPref!!.edit()
            prefsEditor.putString(key, value)
            prefsEditor.apply()
        }
    }
}