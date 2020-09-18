package tw.nolions.tdd

class UserService {
    fun userDataByListener(id: Int, listener: UserDataReceivedListener) {
        val user = UserModel(
            id = id,
            name = "John"
        )

        delayed { listener.onUserReceived(user) }
    }

    fun userDataByLambda(id: Int, f: (user: UserModel) -> Unit) {
        delayed { f(UserModel(id, "John")) }
    }

    private fun delayed(f: () -> Unit) {
        val handler = android.os.Handler()
        handler.postDelayed({
            f.invoke()
        }, 1000)
    }

    interface UserDataReceivedListener {
        fun onUserReceived(user: UserModel)
    }
}