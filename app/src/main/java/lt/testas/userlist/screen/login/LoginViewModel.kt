package lt.testas.userlist.screen.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import lt.testas.userlist.base.BaseViewModel
import lt.testas.userlist.navigation.AppNavigator
import lt.testas.userlist.navigation.Screen
import lt.testas.util.Validator
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val appNavigator: AppNavigator,
) : BaseViewModel<LoginViewModel.State>(State()) {

    data class State(
        val showEmailError: Boolean = false,
        val showPasswordError: Boolean = false,
    )

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val isEmailValid = Validator.validateEmail(email)
            val isPasswordValid = Validator.validatePassword(password)
            setState(
                state.copy(
                    showEmailError = !isEmailValid,
                    showPasswordError = !isPasswordValid
                )
            )
            if (isEmailValid && isPasswordValid) {
                appNavigator.setRoot(Screen.Detail)
            }
        }
    }

    fun userTyped() {
        setState(
            state.copy(
                showEmailError = false,
                showPasswordError = false
            )
        )
    }

}
