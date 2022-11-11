package lt.testas.userlist.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lt.testas.userlist.theme.theme.TestUserListTheme

@Composable
fun LoginScreen() {
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Text(text = "LOGIN SCREEN")
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    TestUserListTheme {
        LoginScreen()
    }
}