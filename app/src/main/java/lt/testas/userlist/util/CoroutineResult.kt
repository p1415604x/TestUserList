package lt.testas.userlist.util

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException

inline fun <R> runCatchingCoroutine(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (t: TimeoutCancellationException) {
        Result.failure(t)
    } catch (c: CancellationException) {
        throw c
    } catch (e: Throwable) {
        Result.failure(e)
    }
}