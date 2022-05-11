@file:OptIn(ExperimentalContracts::class)
@file:Suppress("RedundantSuspendModifier")

package dev.skrilltrax.baka.core.util.extension

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.withContext

/**
 * Calls the specified function [block] with [this] value as its receiver and returns its
 * encapsulated result if invocation was successful, catching any [Throwable] except
 * [CancellationException] that was thrown from the [block] function execution and encapsulating it
 * as a failure.
 */
@Suppress("REDUNDANT_INLINE_SUSPEND_FUNCTION_TYPE")
public suspend inline fun <V> runSuspendCatching(block: suspend () -> V): Result<V, Throwable> {
  contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }

  return try {
    Ok(block())
  } catch (e: Throwable) {
    if (e is CancellationException) throw e
    Err(e)
  }
}

/**
 * Calls the specified function [block] with [this] value as its receiver and returns its
 * encapsulated result if invocation was successful, catching any [Throwable] except
 * [CancellationException] that was thrown from the [block] function execution and encapsulating it
 * as a failure.
 */
public suspend inline infix fun <T, V> T.runSuspendCatching(
  block: T.() -> V
): Result<V, Throwable> {
  contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }

  return try {
    Ok(block())
  } catch (e: Throwable) {
    if (e is CancellationException) throw e
    Err(e)
  }
}

public suspend inline fun <V> runSuspendCatchingWithContext(
  context: CoroutineContext,
  crossinline block: suspend () -> V
): Result<V, Throwable> =
  withContext(context) {
    return@withContext runSuspendCatching(block)
  }

