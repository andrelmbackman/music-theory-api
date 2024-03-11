package com.example

import org.junit.Test
import org.junit.Assert.assertEquals
import com.example.NoteGenerator.*
import com.example.*

class NoteGeneratorTest {
    /**
     * Test if the correct set of notes is returned for the given key and scale.
     */
    @Test
    fun testKeySignature() {
        val gen = NoteGenerator()
        assert(gen.getNoteSet("F", "major") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Bb", "major") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Eb", "major") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Ab", "major") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Db", "major") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Gb", "major") == setOf("Gb", "G", "Ab", "A", "Bb", "Cb", "C", "Db", "D", "Eb", "E", "F"))

        assert(gen.getNoteSet("D", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("G", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("C", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("F", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Bb", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Eb", "minor") == setOf("Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "Cb", "C", "Db", "D"))

        assert(gen.getNoteSet("G", "major") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("D", "major") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("A", "major") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("E", "major") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("B", "major") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("F#", "major") == Constants.SHARP_NOTESET)

        assert(gen.getNoteSet("E", "minor") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("B", "minor") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("F#", "minor") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("C#", "minor") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("G#", "minor") == Constants.SHARP_NOTESET)
        assert(gen.getNoteSet("D#", "minor") == Constants.SHARP_NOTESET)
    }

    /**
    * Test if the key is changed to use the appropriate noteset for least key signatures.
    */
    @Test
    fun testSwitchKeyToLeastSignatures() {
        val gen = NoteGenerator()
        assert(gen.switchKeyToLeastSignatures("A#", "major") == "Bb")
        assert(gen.switchKeyToLeastSignatures("D#", "major") == "Eb")
        assert(gen.switchKeyToLeastSignatures("G#", "major") == "Ab")
        assert(gen.switchKeyToLeastSignatures("C#", "major") == "Db")

        assert(gen.switchKeyToLeastSignatures("Ab", "minor") == "G#")
        assert(gen.switchKeyToLeastSignatures("Db", "minor") == "C#")
        assert(gen.switchKeyToLeastSignatures("Gb", "minor") == "F#")
        assert(gen.switchKeyToLeastSignatures("Fb", "minor") == "E")

    }

    /**
     * Test if getMajorNotes returns the right notes for a given key and scale.
     */
    @Test
    fun testGetMajorNotes() {

        val gen = NoteGenerator()

        var notes = gen.getNotes("C", "major")
        var expectedNotes = listOf("C", "D", "E", "F", "G", "A", "B")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("F", "major")
        expectedNotes = listOf("F", "G", "A", "Bb", "C", "D", "E")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Bb", "major")
        expectedNotes = listOf("Bb", "C", "D", "Eb", "F", "G", "A")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Eb", "major")
        expectedNotes = listOf("Eb", "F", "G", "Ab", "Bb", "C", "D")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Ab", "major")
        expectedNotes = listOf("Ab", "Bb", "C", "Db", "Eb", "F", "G")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Db", "major")
        expectedNotes = listOf("Db", "Eb", "F", "Gb", "Ab", "Bb", "C")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Gb", "major")
        expectedNotes = listOf("Gb", "Ab", "Bb", "Cb", "Db", "Eb", "F")
        assertEquals(expectedNotes, notes)

        /**
         * Sharp scales
         */
        notes = gen.getNotes("G", "major")
        expectedNotes = listOf("G", "A", "B", "C", "D", "E", "F#")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("D", "major")
        expectedNotes = listOf("D", "E", "F#", "G", "A", "B", "C#")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("A", "major")
        expectedNotes = listOf("A", "B", "C#", "D", "E", "F#", "G#")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("E", "major")
        expectedNotes = listOf("E", "F#", "G#", "A", "B", "C#", "D#")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("B", "major")
        expectedNotes = listOf("B", "C#", "D#", "E", "F#", "G#", "A#")
        assertEquals(expectedNotes, notes)
    }

    @Test
    fun testGetMinorNotes() {
        val gen = NoteGenerator()

        var notes = gen.getNotes("C", "minor")
        var expectedNotes = listOf("C", "D", "Eb", "F", "G", "Ab", "Bb")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("D", "minor")
        expectedNotes = listOf("D", "E", "F", "G", "A", "Bb", "C")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("G", "minor")
        expectedNotes = listOf("G", "A", "Bb", "C", "D", "Eb", "F")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("F", "minor")
        expectedNotes = listOf("F", "G", "Ab", "Bb", "C", "Db", "Eb")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Bb", "minor")
        expectedNotes = listOf("Bb", "C", "Db", "Eb", "F", "Gb", "Ab")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("Eb", "minor")
        expectedNotes = listOf("Eb", "F", "Gb", "Ab", "Bb", "Cb", "Db")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("A", "minor")
        expectedNotes = listOf("A", "B", "C", "D", "E", "F", "G")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("E", "minor")
        expectedNotes = listOf("E", "F#", "G", "A", "B", "C", "D")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("B", "minor")
        expectedNotes = listOf("B", "C#", "D", "E", "F#", "G", "A")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("F#", "minor")
        expectedNotes = listOf("F#", "G#", "A", "B", "C#", "D", "E")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("C#", "minor")
        expectedNotes = listOf("C#", "D#", "E", "F#", "G#", "A", "B")
        assertEquals(expectedNotes, notes)

        notes = gen.getNotes("G#", "minor")
        expectedNotes = listOf("G#", "A#", "B", "C#", "D#", "E", "F#")
        assertEquals(expectedNotes, notes)
    }
}