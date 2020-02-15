package com.example.practiceapplication.MainFeature

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.practiceapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val testerVal = "testerValue"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        setDrinkListFragment()

        floating_btn.setOnClickListener { view ->
            Snackbar.make(view, "Floating button pressed", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setDrinkListFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(main_frame_layout.id, DrinkListFragment(), "MainActivity_DrinkListFrag")
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
