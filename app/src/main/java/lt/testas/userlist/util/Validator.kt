package lt.testas.userlist.util

object Validator {
    val lengthRegex = Regex("(.{6,})")
    var emailRegex =
        Regex("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")

    fun validatePassword(password: String): Boolean {
        return lengthRegex.matches(password)
    }

    fun validateEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

}