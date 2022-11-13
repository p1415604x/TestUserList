package lt.testas.userlist.network

import lt.testas.userlist.network.response.RandomUserResponse
import retrofit2.http.GET


interface UserApi {

    @GET("api/")
    suspend fun getUsers(): RandomUserResponse

}