package lt.testas.userlist

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

@HiltAndroidApp
class App: Application() {

    object AppScope : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = Dispatchers.IO + SupervisorJob()
    }

}