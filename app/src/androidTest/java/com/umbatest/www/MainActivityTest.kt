package com.umbatest.www

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
public class MainActivityTest {
    @get:Rule
    public var mActivityRule: ActivityScenarioRule <MainActivity> = ActivityScenarioRule (MainActivity::class.java)

    @Test
    fun isBottomViewItemsBeClickable(){
        onView((withId(R.id.latest_item))).perform(click())
       onView(withId(R.id.popular_item)).perform(click())
       onView(withId(R.id.upcoming_item)).perform(click())
    }
    @Test
    fun firstMenuItemClickedRecyclerItemClickedToo(){

    }

}