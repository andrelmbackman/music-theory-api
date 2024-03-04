package com.example

import org.junit.Test
import org.junit.Assert.assertEquals
import com.example.NoteGenerator.*

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
        assert(gen.getNoteSet("Gb", "major") == Constants.FLAT_NOTESET)

        assert(gen.getNoteSet("D", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("G", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("C", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("F", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Bb", "minor") == Constants.FLAT_NOTESET)
        assert(gen.getNoteSet("Eb", "minor") == Constants.FLAT_NOTESET)

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
        val flatNoteSet = Constants.FLAT_NOTESET
        val sharpNoteSet = Constants.SHARP_NOTESET
        val flatNoteList = CircularList<String>()
        val sharpNoteList = CircularList<String>()
        flatNoteSet.forEach { flatNoteList.add(it) }
        sharpNoteSet.forEach { sharpNoteList.add(it)}

        var notes = flatNoteList.getMajorNotes()
        var expectedNotes = listOf("C", "D", "E", "F", "G", "A", "B")
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("F")
        notes = flatNoteList.getMajorNotes()
        expectedNotes = listOf("F", "G", "A", "Bb", "C", "D", "E")
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("Bb")
        notes = flatNoteList.getMajorNotes()
        expectedNotes = listOf("Bb", "C", "D", "Eb", "F", "G", "A")
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("Eb")
        notes = flatNoteList.getMajorNotes()
        expectedNotes = listOf("Eb", "F", "G", "Ab", "Bb", "C", "D")
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("Ab")
        notes = flatNoteList.getMajorNotes()
        expectedNotes = listOf("Ab", "Bb", "C", "Db", "Eb", "F", "G")
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("Db")
        notes = flatNoteList.getMajorNotes()
        expectedNotes = listOf("Db", "Eb", "F", "Gb", "Ab", "Bb", "C")
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("Gb")
        notes = flatNoteList.getMajorNotes()
        expectedNotes = listOf("Gb", "Ab", "Bb", "Cb", "Db", "Eb", "F")
        assertEquals(expectedNotes, notes)

    }

    @Test
    fun testGetMinorNotes() {
        val flatNoteSet = Constants.FLAT_NOTESET
        val sharpNoteSet = Constants.SHARP_NOTESET
        val flatNoteList = CircularList<String>()
        val sharpNoteList = CircularList<String>()
        flatNoteSet.forEach { flatNoteList.add(it) }
        sharpNoteSet.forEach { sharpNoteList.add(it)}

        var expectedNotes = listOf("C", "D", "Eb", "F", "G", "Ab", "Bb")
        var notes = flatNoteList.getMinorNotes()
        assertEquals(expectedNotes, notes)

        flatNoteList.shiftToKey("F")
        notes = flatNoteList.getMinorNotes()
        expectedNotes = listOf("F", "G", "Ab", "Bb", "C", "Db", "Eb")
        assertEquals(expectedNotes, notes)
    }
}