package com.example.practiceapplication.MainFeature

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.DisplayMetrics
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import com.example.practiceapplication.MainFeature.Alerts.Alert
import com.example.practiceapplication.MainFeature.Alerts.CustomAlert
import com.example.practiceapplication.MainFeature.Alerts.ICustomAlertHolder
import com.example.practiceapplication.MainFeature.DrinksList.DrinkListFragment
import com.example.practiceapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_layout.*
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation
import androidx.core.content.ContextCompat.getSystemService




class MainActivity : AppCompatActivity(), ICustomAlertHolder {

    override fun pressOutOfNotification() {
        onBackPressed()
    }

    override fun onBackPressed() {

        if (custom_base.isVisible) {
            customAlert.hideAlerts()
        }
        else {
            super.onBackPressed()
        }
    }

    val testerVal = "testerValue"
    lateinit var customAlert: CustomAlert

    private fun initCustomAlert() {

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels.toFloat()

        customAlert = CustomAlert(screenHeight, this)
        customAlert.updateData(arrayListOf(Alert("description", "link"),
            Alert("description", "link"),
            Alert("description", "link"),
            Alert("description", "link")))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        setDrinkListFragment()

        initCustomAlert()


        // Add custom Alert view
        val vg = window.decorView.rootView as ViewGroup
        vg.addView(customAlert)

        floating_btn.setOnClickListener { view ->
            Snackbar.make(view, "Floating button pressed", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            showAlert()
        }
    }

    private fun showAlert() {
        customAlert.showAlerts()
    }

    private fun setDrinkListFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(main_frame_layout.id,
                DrinkListFragment(), "MainActivity_DrinkListFrag")
            .disallowAddToBackStack()
            .commit()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Snackbar.make(findViewById<View>(android.R.id.content), "Toolbar settings button pressed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                true
            }
            R.id.action_second -> {
                Snackbar.make(findViewById<View>(android.R.id.content), "Toolbar SECOND button pressed", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
