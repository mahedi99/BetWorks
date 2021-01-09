package com.mahedi.betworks

import com.mahedi.betworks.data.model.ChildLoginViewObjTest
import com.mahedi.betworks.data.model.LoggedInUserTest
import com.mahedi.betworks.data.model.ParentLoginViewObjTest
import com.mahedi.betworks.ui.login.LoginFormStateTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * @author Mahedi Hassan
 * 2021-01-08
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
        ChildLoginViewObjTest::class,
        ParentLoginViewObjTest::class,
        LoggedInUserTest::class,
        LoginFormStateTest::class
)
class TestSuite {
}