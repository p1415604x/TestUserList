package lt.testas.userlist.network.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class UserNameDto(
    val title: String,
    @SerialName("first")
    val name: String,
    @SerialName("last")
    val surname: String,
) {

    fun getFullName(): String {
        return "$title $name $surname"
    }

}