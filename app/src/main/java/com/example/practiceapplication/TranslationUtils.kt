package com.example.practiceapplication

import android.view.View
import android.view.animation.TranslateAnimation

object TranslationUtils {
    // To animate view slide out from left to right
    fun slideToRight(view: View) {
        val animate = TranslateAnimation(0f, view.width.toFloat(), 0f, 0f)
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }

    // To animate view slide out from right to left
    fun slideToLeft(view: View) {
        val animate = TranslateAnimation(0f, (-view.width).toFloat(), 0f, 0f)
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }

    // To animate view slide out from top to bottom
    fun slideToBottom(view: View) {
        val animate = TranslateAnimation(0f, 0f, 0f, view.height.toFloat())
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }

    // To animate view slide out from bottom to top
    fun slideToTop(view: View) {
        val animate = TranslateAnimation(0f, 0f, 0f, (-view.height).toFloat())
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        view.visibility = View.GONE
    }

}