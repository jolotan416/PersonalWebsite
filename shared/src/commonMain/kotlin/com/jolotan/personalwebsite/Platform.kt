package com.jolotan.personalwebsite

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform