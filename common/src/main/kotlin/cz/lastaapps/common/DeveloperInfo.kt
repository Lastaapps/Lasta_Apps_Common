package cz.lastaapps.common

import android.content.Context
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DeveloperInfo {

    fun getName(context: Context): String {
        return context.getString(R.string.developer_name)
    }

    fun getNameAndBuildYear(context: Context): String {
        val date = LocalDate.parse(BuildConfig.BUILD_DATE)
        val formatted = date.format(DateTimeFormatter.ofPattern("yyyy"))

        return context.getString(R.string.developer_name_date, formatted)
    }

}