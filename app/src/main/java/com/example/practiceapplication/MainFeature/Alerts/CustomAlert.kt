package com.example.practiceapplication.MainFeature.Alerts

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceapplication.R
import kotlinx.android.synthetic.main.alert_layout.view.*

class CustomAlert(private val screenHeight: Float, context: Context): RelativeLayout(context) {

    private val alertAdaptor: AlertAdaptor = AlertAdaptor()
    private val exiter: ICustomAlertHolder = context as ICustomAlertHolder

    init {

        LayoutInflater.from(context).inflate(R.layout.alert_layout, this, true)
        alert_recycler_view.layoutManager = LinearLayoutManager(context)
        alert_recycler_view.adapter = alertAdaptor

        custom_base.setOnClickListener {
            exiter.pressOutOfNotification()
        }

        hide()
    }

    fun updateData(alerts: ArrayList<Alert>) {
        alertAdaptor.alerts.clear()
        alertAdaptor.alerts.addAll(alerts)
        alertAdaptor.notifyDataSetChanged()
    }

    fun showAlerts() {
        ObjectAnimator.ofFloat(this, "y",  (-1) * screenHeight, 0f).apply {
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator?) {
                    this@CustomAlert.show()
                }
            })
            interpolator = DecelerateInterpolator(2f)
            duration = 1000
            start()
        }
    }

    fun hideAlerts() {
        ObjectAnimator.ofFloat(this, "y", 0f, (-1) * screenHeight).apply {
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    this@CustomAlert.hide()
                }
            })
            duration = 750
            start()
        }
    }

    private fun show() {
        this.visibility = View.VISIBLE
    }

    private fun hide() {
        this.visibility = View.GONE
    }



}