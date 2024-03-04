package com.example

import com.example.Constants.FLAT_NOTESET
import com.example.Constants.SHARP_NOTESET
import org.junit.Test
import kotlin.test.*
import com.example.NoteGenerator
class ValidationTest {
    @Test
    fun testValidKeys() {
        val validKeys = listOf("C", "C#", "Db", "D", "Eb", "E", "F", "F#", "G", "Ab", "A", "Bb", "B")
        validKeys.forEach {
            assertTrue(validateKey(it), "Failed for key: $it")
        }
    }

    @Test
    fun testInvalidKeys() {
        val invalidKeys = listOf("Q", "W", "l", "1", "Ö", "Gee", "Major", "minor")
        invalidKeys.forEach {
            assertFalse(validateKey(it), "Failed for key: $it")
        }
    }


    @Test
    fun testScales() {
        assertTrue(validateScale("major"))
        assertTrue(validateScale("minor"))

        assertFalse(validateScale("whole tone"))
        assertFalse(validateScale("microtonal"))
        assertFalse(validateScale("hypermegametamixolydian"))
    }
}


