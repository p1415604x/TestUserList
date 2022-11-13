package lt.testas.userlist.network.dto

@kotlinx.serialization.Serializable
data class UserImageDto(
    val large: String,
    val medium: String,
    val thumbnail: String
)