package lt.testas.userlist.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import lt.testas.userlist.base.BaseUseCase
import lt.testas.userlist.network.UserApi
import lt.testas.userlist.network.dto.UserDto
import lt.testas.userlist.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userApi: UserApi,
    private val userRepository: UserRepository,
    dispatcher: CoroutineDispatcher
) : BaseUseCase(dispatcher) {

    suspend fun downloadUsers() = withContext(dispatcher) {
        repeat(3) {
            val user = userApi.getUsers()
            userRepository.addUsers(user.results)
        }
    }

    fun getUsers(): Flow<List<UserDto>> {
        return userRepository.users
    }

}