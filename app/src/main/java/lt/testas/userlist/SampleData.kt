package lt.testas.userlist

import lt.testas.userlist.network.dto.*

object SampleData {

    val userDto = UserDto(
        name = UserNameDto(
            "Mr",
            "John",
            "Thompson"
        ),
        address = AddressDto(
            street = StreetDto(
                number = 15,
                name = "Kauno g."
            ),
            city = "Klaipėda",
            state = "",
            country = "Lithuania",
            postCode = 55555
        ),
        email = "john.thompson@gmail.com",
        picture = UserImageDto(
            large = "https://randomuser.me/api/portraits/thumb/women/91.jpg",
            medium = "https://randomuser.me/api/portraits/thumb/women/91.jpg",
            thumbnail = "https://randomuser.me/api/portraits/thumb/women/91.jpg"
        )
    )
}