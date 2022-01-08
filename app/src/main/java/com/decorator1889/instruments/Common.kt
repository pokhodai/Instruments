package com.decorator1889.instruments

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

fun showToast(context: Context?, message: String?) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun getDefaultShimmer(context: Context): Drawable {
    val shimmer = Shimmer.ColorHighlightBuilder().setBaseColor(
        ContextCompat.getColor(context, R.color.backgroundDefaultShimmer)
    ).setHighlightColor(
        ContextCompat.getColor(context, R.color.shimmer)
    ).setDuration(1000)
        .setBaseAlpha(1f)
        .setHighlightAlpha(1f)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()
    return ShimmerDrawable().apply {
        setShimmer(shimmer)
    }
}

fun ImageView.glide(url: String) {
    Glide
        .with(this)
//        .load(getUriForBackendImagePath(url))
        .load(url)
        .placeholder(getDefaultShimmer(this.context))
        .error(R.color.black)
        .into(this)
}