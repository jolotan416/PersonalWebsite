package com.jolotan.personalwebsite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
/** Triggers a browser download of the file at [url], saved as [fileName]. */
expect fun downloadFile(url: String, fileName: String)

/** Looks up the visitor's ISO-3166 alpha-2 country code (e.g. "PH") by IP, or null on failure. */
expect suspend fun fetchCountryCode(): String?
