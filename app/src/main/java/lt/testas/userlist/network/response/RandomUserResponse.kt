package lt.testas.userlist.network.response

import lt.testas.userlist.network.dto.UserDto

@kotlinx.serialization.Serializable
data class RandomUserResponse(
    val results: List<UserDto>
)









