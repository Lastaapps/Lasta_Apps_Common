package cz.lastaapps.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import androidx.annotation.DrawableRes
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat


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