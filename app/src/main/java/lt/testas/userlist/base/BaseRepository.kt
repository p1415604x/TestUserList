package lt.testas.userlist.base

import kotlinx.coroutines.CoroutineDispatcher

abstract class BaseRepository(protected val dispatcher: CoroutineDispatcher)