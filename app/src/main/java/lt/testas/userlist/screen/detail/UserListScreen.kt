package lt.testas.userlist.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lt.testas.userlist.theme.theme.TestUserListTheme

@Composable
fun UserListScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("USER LIST SCREEN")
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    TestUserListTheme {
        UserListScreen()
    }
}