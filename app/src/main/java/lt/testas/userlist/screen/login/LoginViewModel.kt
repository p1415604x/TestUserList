package lt.testas.userlist.screen.login

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import lt.testas.userlist.base.BaseViewModel
import lt.testas.userlist.navigation.AppNavigator
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val appNavigator: AppNavigator,
) : BaseViewModel<LoginViewModel.State>(State()) {

    data class State(
        val placeHolder: String = ""
    )

}
