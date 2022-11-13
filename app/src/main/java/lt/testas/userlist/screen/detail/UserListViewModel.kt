package lt.testas.userlist.screen.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import lt.testas.userlist.base.BaseViewModel
import lt.testas.userlist.network.dto.UserDto
import lt.testas.userlist.usecase.GetUsersUseCase
import lt.testas.util.runCatchingCoroutine
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getUsersUseCase: GetUsersUseCase,
) : BaseViewModel<UserListViewModel.State>(State()) {

    data class State(
        val originalUsers: List<UserDto> = listOf(),
        val filteredUsers: List<UserDto> = listOf(),
    )

    init {
        viewModelScope.launch {
            runCatchingCoroutine {
                getUsersUseCase.downloadUsers()
            }
        }

        getUsersUseCase.getUsers()
            .onEach {
                setState(state.copy(originalUsers = it + it + it))
            }.launchIn(viewModelScope)
    }

    fun filterUsers(value: String) {
        val filteredUsers = state.originalUsers
            .filter {
                it.name.name.contains(value, true) || it.name.surname.contains(value, true)
            }
        setState(state.copy(filteredUsers = filteredUsers))
    }

}
