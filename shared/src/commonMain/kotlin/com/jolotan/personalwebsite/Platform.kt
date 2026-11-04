package com.jolotan.personalwebsite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
/** Triggers a browser download of the file at [url], saved as [fileName]. */
expect fun downloadFile(url: String, fileName: String)
