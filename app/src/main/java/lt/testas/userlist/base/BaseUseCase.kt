package lt.testas.userlist.base

import kotlinx.coroutines.CoroutineDispatcher

abstract class BaseUseCase(protected val dispatcher: CoroutineDispatcher)