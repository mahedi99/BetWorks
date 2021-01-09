package com.mahedi.betworks

import com.mahedi.betworks.ui.login.LoginActivityTest
import com.mahedi.betworks.ui.welcome.WelcomeActivityTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * @author Mahedi Hassan
 * 2021-01-08
 */

@RunWith(Suite::class)
@Suite.SuiteClasses(
    WelcomeActivityTest::class,
    LoginActivityTest::class
)
class UITestSuite {
}