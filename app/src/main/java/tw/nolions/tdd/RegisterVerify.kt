package tw.nolions.tdd

class RegisterVerify {
    fun verifyUserName(userName: String): Boolean {
        var isLoginIdOK = false
        if (userName.length >= 6) {
            if (userName.toUpperCase().first() in 'A'..'Z') {
                isLoginIdOK = true
            }
        }
        return isLoginIdOK
    }

}
