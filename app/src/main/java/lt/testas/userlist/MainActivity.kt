package lt.testas.userlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import lt.testas.userlist.navigation.AppNavigator
import lt.testas.userlist.navigation.Screen
import lt.testas.userlist.screen.detail.DetailScreen
import lt.testas.userlist.screen.detail.DetailViewModel
import lt.testas.userlist.screen.login.LoginScreen
import lt.testas.userlist.screen.login.LoginViewModel
import lt.testas.userlist.theme.theme.TestUserListTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            TestUserListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { scaffoldPaddings ->
                    Box(modifier = Modifier.padding(scaffoldPaddings)) {
                        val navController = rememberNavController()
                        LaunchedEffect(null) {
                            appNavigator.navigationSharedFlow.collect { command ->
                                command(navController)
                            }
                        }
                        appNavigator.navController = navController
                        TestApp(navController)
                    }
                }
            }
        }
    }

}

@Composable
private fun TestApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            val viewModel: LoginViewModel = hiltViewModel()
            val state by viewModel.stateFlow.collectAsState(Dispatchers.Main.immediate)
            LoginScreen()
        }
        composable(Screen.Detail.route) {
            val viewModel: DetailViewModel = hiltViewModel()
            val state by viewModel.stateFlow.collectAsState(Dispatchers.Main.immediate)
            DetailScreen()
        }
    }
}