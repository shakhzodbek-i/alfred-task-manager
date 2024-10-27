package com.codingcat.task.data

import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.AfterClass
import org.junit.Before

open class BaseTest {

    @Before
    open fun setup() {
        MockKAnnotations.init(this)
    }

    companion object {

        @JvmStatic
        @AfterClass
        fun afterClass() {
            unmockkAll()
        }
    }
}