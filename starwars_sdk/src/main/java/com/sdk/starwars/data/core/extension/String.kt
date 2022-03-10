package com.sdk.starwars.data.core.extension

import com.google.gson.Gson
import com.sdk.starwars.data.core.Constants.DATE_PATTERN_DEFAULT
import java.text.SimpleDateFormat
import java.util.*

internal fun String.toDate(pattern: String = DATE_PATTERN_DEFAULT, local: Locale = Locale.US): Date? =
    try {
        SimpleDateFormat(pattern, local).parse(this) ?: null
    } catch (e: Exception) {
        null
    }