package com.example

object Constants {
    val VALID_KEYS = setOf("C", "Cb", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B")
    val VALID_SCALES = setOf("major", "minor")

    val SHARP_NOTESET = setOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    val FLAT_NOTESET = setOf("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B")
    val MAJOR_TONES_INDEXES = listOf(1, 3, 5, 6, 8, 10, 12)
    val MINOR_TONES_INDEXES = listOf(1, 3, 4, 6, 8, 9, 11)

    val MAJOR_KEY_CONTAINS_SHARP = setOf("G", "D", "A", "E", "B", "F#")
    val MAJOR_KEY_CONTAINS_FLAT = setOf("F", "Bb", "Eb", "Ab", "Db", "Gb")
    val MINOR_KEY_CONTAINS_SHARP = setOf("E", "B", "F#", "C#", "G#", "D#", "A#")
    val MINOR_KEY_CONTAINS_FLAT = setOf("D", "G", "C", "F", "Bb", "Eb", "Ab")
    val MAJOR_CHORD_EXTENSIONS = setOf("", "m", "m", "", "", "m", "mb5")
    val MINOR_CHORD_EXTENSIONS = setOf("m", "mb5", "", "m", "m", "", "")
}

//TODO: C# maj = Db, D# maj = Eb, G# maj = Ab, A# maj = Bb, (Cb = B, Fb = E, E# = F, B# = C), add note text if changed
// MAKE THE CIRCULAR STRUCTURE CHANGE THE PITCH NAME ENHARMONICALLY
/**
 * CHORD TYPES:
 * major
 * minor
 * major7, major6
 * minor7, minor6
 *
 */
