package com.mahedi.betworks.data.model

import org.junit.Assert.*
import org.junit.Test

class ParentLoginViewObjTest {
    private lateinit var parentLoginViewObj: ParentLoginViewObj

    @Test
    fun `is enabled test`() {
        parentLoginViewObj = ParentLoginViewObj()
        assertNotNull(parentLoginViewObj)
        assertFalse(parentLoginViewObj.isEnabled)
        parentLoginViewObj.isEnabled = true
        assertTrue(parentLoginViewObj.isEnabled)
    }

    @Test
    fun `check type`() {
        parentLoginViewObj = ParentLoginViewObj()
        assertEquals(parentLoginViewObj.getType(), ViewType.PARENT.type)
    }
}