package com.mahedi.betworks.data.model

import com.mahedi.betworks.util.Constants
import org.junit.Assert.*
import org.junit.Test

class ChildLoginViewObjTest {

    private lateinit var childLoginViewObj: ChildLoginViewObj

    @Test
    fun `insert data confirmed test`() {
        childLoginViewObj = ChildLoginViewObj(prompt = Constants.EMAIL_PROMPT)
        assertNotNull(childLoginViewObj)
        assertNotNull(childLoginViewObj.prompt)
        childLoginViewObj.data = "acbs"
        assertFalse(childLoginViewObj.data.isEmpty())
    }

    @Test
    fun `check type`() {
        childLoginViewObj = ChildLoginViewObj(prompt = "")
        assertEquals(childLoginViewObj.getType(), ViewType.CHILD.type)
    }
}