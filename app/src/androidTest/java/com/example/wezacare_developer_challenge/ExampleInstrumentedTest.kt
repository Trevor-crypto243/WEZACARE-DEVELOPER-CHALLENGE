package com.example.wezacare_developer_challenge

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test



import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.regex.Pattern.matches

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.wezacare_developer_challenge", appContext.packageName)
    }

    /**
     * Checking whether the action Bar is displayed
     * */

    @Test
    fun actionBarTitleIsDisplayed() {
        val scenario = launch(home_activity::class.java)
        onView(withText("WEZACARE DEVELOPER CHALLENGE")).check(matches(isDisplayed()))
    }

    /**
     * Testing whethe the network state text is displayed correctly
     * */

    @Test
    fun statusTextIsDisplayedCorrectly() {
        val scenario = launch(home_activity::class.java)
        onView(withId(R.id.status)).check(matches(withText("loading....")))
    }

    /***
     * Testing whether the recycler view is displayed
     * **/
    @Test
    fun recyclerViewIsDisplayed() {
        val scenario = launch(home_activity::class.java)
        onView(withId(R.id.recyclerview)).check(matches(isDisplayed()))
    }
}


















