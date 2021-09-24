package com.kawal.mvvm.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.kawal.mvvm.data.model.LoggedInUser

object Session {

    private val USERNAME = "username"
    private val IS_ADMIN = "is_admin"
    private val IS_LOGGIN = "is_loggin"

    fun getPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setSessionUser(context: Context, user: LoggedInUser) {
        val editor = getPreferences(context).edit()

        editor.putString(USERNAME, user.displayName)
        editor.putBoolean(IS_ADMIN, user.isAdmin)
        editor.putBoolean(IS_LOGGIN, true)

        editor.apply()
    }

    fun getSessionUser(context: Context): LoggedInUser {
        val user = LoggedInUser(
                getPreferences(context).getString(USERNAME, null)!!,
                getPreferences(context).getString(USERNAME, null)!!,
                getPreferences(context).getBoolean(IS_ADMIN, false))

        return user
    }

    fun destroySessionUser(context: Context) {
        val editor = getPreferences(context).edit()

        editor.clear()
        editor.apply()
    }

    // custom function
    fun isLoggedIn(context: Context) : Boolean {
        val isLoggedIn = getPreferences(context).getBoolean(IS_LOGGIN, false)

        return isLoggedIn
    }
}
