package tw.nolions.tdd

import android.content.Context
import android.content.SharedPreferences

class Repository(private val context: Context) {
    companion object {
        const val USERNAME_KEY = "USERNAME"
    }
    private var sharedPreference: SharedPreferences =
        context.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)

    fun saveUserName(userName: String) {
        sharedPreference.edit().putString(USERNAME_KEY, userName).apply()
    }

    fun getUserName(): String? {
        return sharedPreference.getString(USERNAME_KEY, "")
    }
}