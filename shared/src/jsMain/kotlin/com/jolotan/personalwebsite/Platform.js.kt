package com.jolotan.personalwebsite

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

import web.navigator.navigator

class JsPlatform: Platform {
    private val userAgent = navigator.userAgent
    private val browserList = listOf("Chrome", "Firefox", "Safari", "Edge")

    override val name: String = userAgent.findAnyOf(browserList, ignoreCase = true)
            ?.let { (startIndex) -> userAgent.substring(startIndex).substringBefore(" ") }
            ?: "Unknown"
}

actual fun getPlatform(): Platform = JsPlatform()

actual fun downloadFile(url: String, fileName: String) = triggerDownload(url, fileName)

private fun triggerDownload(url: String, fileName: String): Unit =
    js("{ const a = document.createElement('a'); a.href = url; a.download = fileName; document.body.appendChild(a); a.click(); a.remove(); }")

private val COUNTRY_CODE_REGEX = Regex("^[A-Z]{2}$")

actual suspend fun fetchCountryCode(): String? = suspendCancellableCoroutine { continuation ->
    requestCountryCode { result ->
        if (continuation.isActive) {
            continuation.resume(result?.takeIf { COUNTRY_CODE_REGEX.matches(it) })
        }
    }
}

private fun requestCountryCode(onResult: (String?) -> Unit): Unit =
    js("{ fetch('https://ipapi.co/country/', { signal: AbortSignal.timeout(3000) }).then(r => r.ok ? r.text() : null).then(t => onResult(t ? t.trim() : null), () => onResult(null)); }")
