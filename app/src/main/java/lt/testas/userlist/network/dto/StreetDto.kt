package lt.testas.userlist.network.dto

@kotlinx.serialization.Serializable
data class StreetDto(
    val number: Int,
    val name: String,
)