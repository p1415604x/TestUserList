package lt.testas.userlist.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lt.testas.userlist.base.BaseRepository
import lt.testas.userlist.network.dto.UserDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    dispatcher: CoroutineDispatcher
) : BaseRepository(dispatcher) {

    private val _users: MutableStateFlow<List<UserDto>> = MutableStateFlow(listOf())
    val users: StateFlow<List<UserDto>> get() = _users

    fun addUsers(users: List<UserDto>) {
        val currentList = _users.value.toMutableList()
        currentList.addAll(users)
        _users.value = currentList
    }

    fun clear() {
        _users.value = listOf()
    }

}