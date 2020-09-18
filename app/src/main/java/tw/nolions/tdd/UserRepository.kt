package tw.nolions.tdd

class UserRepository(private val service: UserService) : UserService.UserDataReceivedListener {
    lateinit var userName: String
    fun userDataByListener() {
        service.userDataByListener(1, this)
    }

    fun userDataByLambda() {
        service.userDataByLambda(1) {
            print(it.name)
            userName = it.name
        }
    }

    override fun onUserReceived(user: UserModel) {
        userName = user.name
    }
}