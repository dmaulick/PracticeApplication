package com.example.practiceapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.practiceapplication.MainFeature.MainActivity
import com.google.common.truth.Truth
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityRecyclerViewTest {


    // espresso cheat sheet:
    // https://developer.android.com/training/testing/espresso/cheat-sheet

    @Test
    fun recyclerViewIsViewable() {

        ActivityScenario.launch(MainActivity::class.java).use { scenario ->

            scenario.moveToState(Lifecycle.State.RESUMED)    // Moves the activity state to State.RESUMED.
            Assert.assertEquals(scenario.state, Lifecycle.State.RESUMED)

            scenario.onActivity { activity ->
                onView(withId(R.id.drink_list_recycler_view))
                    .check(matches(isDisplayed()))
            }
        }

    }
}