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
    fun testKeySignature() {
        val gen = NoteGenerator()
        assert(gen.getNoteSet("F", "major") == FLAT_NOTESET)
        assert(gen.getNoteSet("Bb", "major") == FLAT_NOTESET)
        assert(gen.getNoteSet("Eb", "major") == FLAT_NOTESET)
        assert(gen.getNoteSet("Ab", "major") == FLAT_NOTESET)
        assert(gen.getNoteSet("Db", "major") == FLAT_NOTESET)
        assert(gen.getNoteSet("Gb", "major") == FLAT_NOTESET)

        assert(gen.getNoteSet("D", "minor") == FLAT_NOTESET)
        assert(gen.getNoteSet("G", "minor") == FLAT_NOTESET)
        assert(gen.getNoteSet("C", "minor") == FLAT_NOTESET)
        assert(gen.getNoteSet("F", "minor") == FLAT_NOTESET)
        assert(gen.getNoteSet("Bb", "minor") == FLAT_NOTESET)
        assert(gen.getNoteSet("Eb", "minor") == FLAT_NOTESET)

        assert(gen.getNoteSet("G", "major") == SHARP_NOTESET)
        assert(gen.getNoteSet("D", "major") == SHARP_NOTESET)
        assert(gen.getNoteSet("A", "major") == SHARP_NOTESET)
        assert(gen.getNoteSet("E", "major") == SHARP_NOTESET)
        assert(gen.getNoteSet("B", "major") == SHARP_NOTESET)
        assert(gen.getNoteSet("F#", "major") == SHARP_NOTESET)

        assert(gen.getNoteSet("E", "minor") == SHARP_NOTESET)
        assert(gen.getNoteSet("B", "minor") == SHARP_NOTESET)
        assert(gen.getNoteSet("F#", "minor") == SHARP_NOTESET)
        assert(gen.getNoteSet("C#", "minor") == SHARP_NOTESET)
        assert(gen.getNoteSet("G#", "minor") == SHARP_NOTESET)
        assert(gen.getNoteSet("D#", "minor") == SHARP_NOTESET)
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