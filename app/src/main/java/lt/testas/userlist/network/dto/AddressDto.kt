package lt.testas.userlist.network.dto

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class AddressDto(
    val street: StreetDto,
    val city: String,
    val state: String,
    val country: String,
    @SerialName("postcode")
    val postCode: Int,
)