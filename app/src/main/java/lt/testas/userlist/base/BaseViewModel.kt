package lt.testas.userlist.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<State : Any>(initialState: State) : ViewModel() {

    private val internalState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val stateFlow: StateFlow<State> = internalState
    val state: State
        get() = stateFlow.value

    protected fun setState(handler: State.() -> State) {
        internalState.value = handler(internalState.value)
    }
    protected fun setState(newState: State) {
        internalState.value = newState
    }

}
