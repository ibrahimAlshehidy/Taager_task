package com.ibrahim.taager_task.main.ui


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ibrahim.taager_task.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class ProductsActivityTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(ProductsActivity::class.java)


    @Test
    fun testIsProductsListVisibleOnAppLunch() {
        onView(withId(R.id.rvProducts)).check(matches(isDisplayed()))
    }


}