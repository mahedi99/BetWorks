package com.mahedi.betworks.ui.welcome

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mahedi.betworks.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class WelcomeActivityTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(WelcomeActivity::class.java)

    @Test
    fun isActivityInView() {
        onView(withId(R.id.welcomeView)).check(matches(isDisplayed()))
    }

    @Test
    fun isTitleVisible() {
        onView(withId(R.id.welcome)).check(matches(withText(R.string.welcome)))
    }

    @Test
    fun isUserNameInvisible() {
        onView(withId(R.id.usernameTextView)).check(matches(withText("")))
    }

}