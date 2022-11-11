package lt.testas.userlist.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class Screen(private val args: String = "") : Parcelable {

    val route: String
        get() = this::class.qualifiedName!! + "/$args"

    @Parcelize
    object Login : Screen()

    @Parcelize
    object Detail : Screen()

}
