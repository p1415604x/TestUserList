package lt.testas.userlist.network.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class UserDto(
    val name: UserNameDto,
    @SerialName("location")
    val address: AddressDto,
    val email: String,
    val picture: UserImageDto,
)