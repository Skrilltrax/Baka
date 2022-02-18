package dev.skrilltrax.baka.core.auth

public class AuthTokenNotFoundException(
  override val message: String? = null,
  override val cause: Throwable? = null,
) : Exception()
