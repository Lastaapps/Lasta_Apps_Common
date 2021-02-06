package cz.lastaapps.common

import android.content.Context
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object DeveloperInfo {

    fun getName(context: Context): String {
        return context.getString(R.string.developer_name)
    }

    fun getNameAndBuildYear(context: Context): String {
        val date = ZonedDateTime.ofInstant(
            Instant.ofEpochSecond(BuildConfig.BUILD_DATE),
            ZoneId.of("UTC")
        )
        val formatted = date.format(DateTimeFormatter.ofPattern("yyyy"))

        return context.getString(R.string.developer_name_date, formatted)
    }

}