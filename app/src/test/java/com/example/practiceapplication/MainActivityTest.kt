package com.example.practiceapplication

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.practiceapplication.MainFeature.MainActivity
import com.google.common.truth.Truth
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    // Good resource for testing activity with scenario
    // https://developer.android.com/reference/androidx/test/core/app/ActivityScenario
    // https://medium.com/stepstone-tech/better-tests-with-androidxs-activityscenario-in-kotlin-part-1-6a6376b713ea

    // androidxTestCoreKtx: "androidx.test:core-ktx:1.1.0"

    lateinit var scenario: ActivityScenario<MainActivity>

    @After
    fun cleanup() {
        if (::scenario.isInitialized) scenario.close()
    }

    /**
     *  Example 1:
     *  Using cleanup after to clean up device state after test
     */

    @Test
    fun basicMainActivityTest_1() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = Intent(context, MainActivity::class.java)
            .putExtra("title", "Something different")

        scenario = launchActivity<MainActivity>(intent)
        scenario.onActivity {
            Truth.assertThat(it.testerVal).isEqualTo("testerValue")
        }

    }

    /**
     *  Example 2:
     *  'use' on resource so free after test
     *  show how to assert
     */
    @Test
    fun basicMainActivityTest_2() {

        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.onActivity { activity ->
                Truth.assertThat(activity.testerVal).isEqualTo("testerValue")
            }
        }

    }


    /**
     *  Example 3:
     *  'use' on resource so free after test
     *  show how to move states
     */

    @Test
    fun basicMainActivityTest_3() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            scenario.moveToState(Lifecycle.State.RESUMED)    // Moves the activity state to State.RESUMED.
            scenario.moveToState(Lifecycle.State.STARTED)    // Moves the activity state to State.STARTED.
            scenario.moveToState(Lifecycle.State.CREATED)    // Moves the activity state to State.CREATED.
            assertEquals(scenario.state, Lifecycle.State.CREATED)
            scenario.moveToState(Lifecycle.State.DESTROYED)  // Moves the activity state to State.DESTROYED.
        }
    }
}