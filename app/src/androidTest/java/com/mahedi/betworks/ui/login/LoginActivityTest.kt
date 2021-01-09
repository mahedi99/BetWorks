package com.mahedi.betworks.ui.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mahedi.betworks.R
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {
    @get: Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun isActivityInView() {
        onView(ViewMatchers.withId(R.id.loginView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun recyclerViewTest() {
        onView(ViewMatchers.withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<BaseViewHolder>(
                    0,
                    typeText("user99")
                )
            )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<BaseViewHolder>(
                    1,
                    typeText("myPass09")
                )
            )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<BaseViewHolder>(
                    2,
                    click()
                )
            )

        onView(ViewMatchers.withId(R.id.welcomeView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.usernameTextView)).check(
            ViewAssertions.matches(
                ViewMatchers.withText(
                    "JOHN DOE"
                )
            )
        )
    }

}