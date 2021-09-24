package com.kawal.mvvm.data

import com.kawal.mvvm.Const
import com.kawal.mvvm.data.model.LoggedInUser
import com.kawal.mvvm.util.Session
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            var success = false
            var fixedUser: LoggedInUser? = null

            if (username.equals(Const.ADMIN_EMAIL, true) && password.equals(Const.ADMIN_PASS, false)) {
                fixedUser = LoggedInUser("admin", "Administrator", true)
                success = true
            }

            if (username.equals(Const.GUEST_EMAIL, true) && password.equals(Const.GUEST_PASS)) {
                fixedUser = LoggedInUser("guest", "Guest", false)
                success = true
            }

            if(success) {
                return Result.Success(fixedUser)
            }

            return Result.Error(IOException("Wrong Username/Password", null))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}