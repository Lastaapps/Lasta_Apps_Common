package cz.lastaapps.common

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

object Communication {

    private const val facebookUrl = "https://www.facebook.com/lastaapps/"
    private const val githubUrl = "https://github.com/lastaapps/"
    private const val telegramUrl = "https://t.me/lasta_apps"
    private const val playStoreUrl = "https://play.google.com/store/apps/dev?id=8043580628539311707"

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
        val uri = Uri.parse(url)
        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
    }

    object Icons {

        private fun facebook(
            context: Context,
            foreground: Int? = null,
            background: Int? = null,
        ): Drawable = getIcon(
            context,
            R.drawable.ic_facebook_foreground,
            R.drawable.ic_facebook_background,
            foreground,
            background,
        )

        private fun github(
            context: Context,
            foreground: Int? = null,
            background: Int? = null,
        ): Drawable = getIcon(
            context,
            R.drawable.ic_github_foreground,
            R.drawable.ic_github_background,
            foreground,
            background,
        )

        private fun playStore(context: Context): Drawable =
            VectorDrawableCompat.create(
                context.resources,
                R.drawable.ic_play_store,
                context.theme
            )!!

        private fun telegram(
            context: Context,
            foreground: Int? = null,
            background: Int? = null,
        ): Drawable = getIcon(
            context,
            R.drawable.ic_telegram_foreground,
            R.drawable.ic_telegram_background,
            foreground,
            background,
        )

        private fun getIcon(
            context: Context,
            @DrawableRes fId: Int,
            @DrawableRes bId: Int,
            fColor: Int?,
            bColor: Int?,
        ): Drawable {

            val fDrawable = loadDrawable(context, fId, fColor)
            val bDrawable = loadDrawable(context, bId, bColor)

            return LayerDrawable(arrayOf(fDrawable, bDrawable))
        }

        private fun loadDrawable(context: Context, id: Int, tint: Int?): VectorDrawableCompat {
            return VectorDrawableCompat.create(context.resources, id, context.theme)!!.apply {
                tint?.let {
                    setTint(it)
                }
            }
        }
    }
}