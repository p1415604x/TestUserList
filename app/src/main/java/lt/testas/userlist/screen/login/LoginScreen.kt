package lt.testas.userlist.screen.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import lt.testas.userlist.R
import lt.testas.userlist.component.AppButton
import lt.testas.userlist.component.AppTextField
import lt.testas.userlist.component.Gap
import lt.testas.userlist.component.GapWeight
import lt.testas.userlist.theme.theme.TestUserListTheme
import lt.testas.userlist.theme.theme.TestUserTheme

@Composable
fun LoginScreen(
    state: LoginViewModel.State,
    onLoginClicked: (String, String) -> Unit,
    onUserTyped: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = TestUserTheme.dimen.screenHorizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }
        GapWeight()
        Text(
            text = stringResource(id = R.string.login_title),
            style = MaterialTheme.typography.h6
        )
        GapWeight(0.25f)
        AppTextField(
            value = email.value,
            onValueChange = {
                email.value = it
                onUserTyped.invoke()
            },
            placeholder = {
                Text(text = stringResource(id = R.string.login_email_pl), style = MaterialTheme.typography.body2)
            },
            label = {
                Text(text = stringResource(id = R.string.login_email_pl), style = MaterialTheme.typography.body2)
            },
            isError = state.showEmailError,
            errorMessage = stringResource(id = R.string.login_email_error),
            singleLine = true,
            keyboardActions = KeyboardActions(onNext = { focusRequester.requestFocus() })
        )
        Gap()
        AppTextField(
            modifier = Modifier.focusRequester(focusRequester),
            value = password.value,
            onValueChange = {
                password.value = it
                onUserTyped.invoke()
            },
            placeholder = {
                Text(text = stringResource(id = R.string.login_password_pl), style = MaterialTheme.typography.body2)
            },
            label = {
                Text(text = stringResource(id = R.string.login_password_pl), style = MaterialTheme.typography.body2)
            },
            isError = state.showPasswordError,
            errorMessage = stringResource(id = R.string.login_password_error),
            singleLine = true,
        )
        Gap()
        AppButton(
            onClick = { onLoginClicked.invoke(email.value, password.value) }
        ) {
            Text(text = stringResource(id = R.string.login_button))
        }
        GapWeight()
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    TestUserListTheme {
        LoginScreen(LoginViewModel.State(), { _, _ -> }, {})
    }
}

@Preview
@Composable
private fun DefaultPreviewWrongEmail() {
    TestUserListTheme {
        LoginScreen(LoginViewModel.State(showEmailError = true), { _, _ -> }, {})
    }
}

@Preview
@Composable
private fun DefaultPreviewWrongPassword() {
    TestUserListTheme {
        LoginScreen(LoginViewModel.State(showPasswordError = true), { _, _ -> }, {})
    }
}