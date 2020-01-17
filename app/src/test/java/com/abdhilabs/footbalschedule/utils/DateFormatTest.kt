package com.abdhilabs.footbalschedule.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class DateFormatTest {

    //Coba testing
    @Test
    fun dateFormat() {
        assertEquals("May 22, 2000", "2000-05-22".toDate())
    }
}