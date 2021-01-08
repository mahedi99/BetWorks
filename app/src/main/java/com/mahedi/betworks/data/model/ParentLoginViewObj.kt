package com.mahedi.betworks.data.model

/**
 * @author Mahedi Hassan
 * 2021-01-07
 */

data class ParentLoginViewObj(var isEnabled: Boolean = false): HasType {
    override fun getType(): Int {
        return ViewType.PARENT.type
    }
}