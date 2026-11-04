package com.jolotan.personalwebsite

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()

actual fun downloadFile(url: String, fileName: String) = triggerDownload(url, fileName)

private fun triggerDownload(url: String, fileName: String): Unit =
    js("{ const a = document.createElement('a'); a.href = url; a.download = fileName; document.body.appendChild(a); a.click(); a.remove(); }")