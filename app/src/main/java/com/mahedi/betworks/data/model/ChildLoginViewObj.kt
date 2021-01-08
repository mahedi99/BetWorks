package com.mahedi.betworks.data.model

/**
 * @author Mahedi Hassan
 * 2021-01-07
 */

data class ChildLoginViewObj(
    var data: String = "",
    var errorMessage: String = "",
    val prompt: String
) : HasType {
    override fun getType(): Int {
        return ViewType.CHILD.type
    }
}