package cz.lastaapps.common

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log

object Communication {

    private val TAG get() = Communication::class.simpleName

    private const val facebookUrl = "https://www.facebook.com/lastaapps/"
    private const val githubUrl = "https://github.com/lastaapps/"
    private const val telegramUrl = "https://t.me/lasta_apps"
    private const val playStoreUrl = "https://play.google.com/store/apps/developer?id=Lasta+apps"

    fun openFacebook(context: Context) = openFacebookPage(context, facebookUrl)

    fun openFacebookPage(context: Context, url: String) {
        var uri = Uri.parse(url)
        try {
            val applicationInfo =
                context.packageManager.getApplicationInfo("com.facebook.katana", 0)

            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=$url")
            }
        } catch (ignored: PackageManager.NameNotFoundException) {
        }

        Log.i(TAG, "Opening facebook link: $uri")

        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    fun openGithub(context: Context) = openUrl(context, githubUrl)

    fun openProjectsGithub(context: Context, name: String) =
        openUrl(context, "$githubUrl$name/")

    fun openProjectsCommits(context: Context, name: String) =
        openUrl(context, "$githubUrl$name/commits/")

    fun openTelegram(context: Context) = openUrl(context, telegramUrl)

    fun openPlayStore(context: Context) = openUrl(context, playStoreUrl)

    private fun openUrl(context: Context, url: String) {

        Log.i(TAG, "Opening link: $url")

        val uri = Uri.parse(url)
        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

}