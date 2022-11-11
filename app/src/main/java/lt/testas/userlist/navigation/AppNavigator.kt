package lt.testas.userlist.navigation

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.runtime.Stable
import androidx.core.app.ComponentActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import lt.testas.userlist.App
import lt.testas.userlist.App.AppScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Stable
class AppNavigator @Inject constructor() {

    var navController: NavController? = null

    val navigationSharedFlow: MutableSharedFlow<NavigationCommand> = MutableSharedFlow()

    fun navigate(
        screen: Screen,
        popExtras: PopExtras? = null,
    ) {
        emit { navController ->
            if (navController.currentDestination?.route == screen.route)
                return@emit

            val options = NavOptions.Builder()
                .setEnterAnim(android.R.anim.fade_in)
                .setExitAnim(android.R.anim.fade_out)
                .setPopEnterAnim(android.R.anim.fade_in)
                .setPopExitAnim(android.R.anim.fade_out)
                .setPopUpTo(popExtras?.route, popExtras?.inclusive ?: false, false)
                .build()

            navController.navigate(screen.route, options)
        }
    }

    fun setRoot(screen: Screen) {
        emit { navController ->
            if (navController.currentDestination?.route == screen.route) {
                return@emit
            }

            val options = NavOptions.Builder()
                .setEnterAnim(android.R.anim.fade_in)
                .setExitAnim(android.R.anim.fade_out)
                .setPopEnterAnim(android.R.anim.fade_in)
                .setPopExitAnim(android.R.anim.fade_out)
                .setPopUpTo(navController.currentDestination?.route, true)
                .build()

            navController.navigate(screen.route, options)
        }
    }

    fun back(popExtras: PopExtras? = null): Deferred<Unit> {
        return emit { navController ->
            if (popExtras != null) {
                navController.popBackStack(popExtras.route, popExtras.inclusive)
            } else {
                navController.popBackStack()
            }
        }
    }

    private fun emit(navigationCommand: NavigationCommand): Deferred<Unit> {
        return AppScope.async(Dispatchers.Main.immediate) { navigationSharedFlow.emit(navigationCommand) }
    }

    data class PopExtras(val route: String, val inclusive: Boolean = false) {
        constructor(screen: Screen, inclusive: Boolean = false) : this(screen.route, inclusive)
    }

}
typealias NavigationCommand = (NavController) -> Unit
