package com.jolotan.personalwebsite.ui.util

data class ResumeVersion(val path: String, val fileName: String)

/** ISO-3166 alpha-2 codes of countries where a photo on a resume is customary or expected. */
private val COUNTRY_CODES_FOR_HEADSHOTS = setOf(
    // Western & Southern Europe
    "DE", "AT", "CH", "LI", "LU", "BE", "FR", "ES", "PT", "IT", "GR",
    // Central & Eastern Europe
    "PL", "CZ", "SK", "HU", "SI", "HR", "RS", "RO", "BG", "UA", "RU", "TR",
    // East Asia
    "JP", "CN", "KR", "TW", "HK", "MO",
    // Southeast Asia
    "PH", "ID", "MY", "TH", "VN",
    // Middle East & North Africa
    "AE", "SA", "QA", "KW", "BH", "OM", "JO", "LB", "EG",
    // Latin America
    "BR", "MX", "AR", "CL", "CO", "PE",
)

fun resumeFor(countryCode: String?): ResumeVersion = if (countryCode in COUNTRY_CODES_FOR_HEADSHOTS) {
    ResumeVersion("/resume-with-headshot.pdf", "John-Louise-Tan-Resume.pdf")
} else {
    ResumeVersion("/resume.pdf", "John-Louise-Tan-Resume.pdf")
}
