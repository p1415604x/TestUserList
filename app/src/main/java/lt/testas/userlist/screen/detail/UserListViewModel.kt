package lt.testas.userlist.screen.detail

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import lt.testas.userlist.base.BaseViewModel
import lt.testas.userlist.navigation.AppNavigator
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val appNavigator: AppNavigator,
) : BaseViewModel<UserListViewModel.State>(State()) {

    data class State(
        val placeHolder: String = ""
    )

}
