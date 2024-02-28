package com.example

object Constants {
    val VALID_KEYS = setOf("C", "C#", "Db", "D", "D#", "Eb", "E", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B")

    val VALID_SCALES = setOf("major", "minor")

    val SHARP_NOTES = setOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")

    val FLAT_NOTES = setOf("C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B")

    val MAJOR_KEY_CONTAINS_SHARP = setOf("G", "D", "A", "E", "B", "F#")

    val MAJOR_KEY_CONTAINS_FLAT = setOf("F", "Bb", "Eb", "Ab", "Db", "Gb")

    val MINOR_KEY_CONTAINS_SHARP = setOf("E", "B", "F#", "C#", "G#", "D#", "A#")

    val MINOR_KEY_CONTAINS_FLAT = setOf("D", "G", "C", "F", "Bb", "Eb", "Ab")

    val MAJOR_CHORD_EXTENSIONS = setOf("", "m", "m", "", "", "m", "mb5")

    val MINOR_CHORD_EXTENSIONS = setOf("m", "mb5", "", "m", "m", "", "")
}

//TODO: C# = Db, D# = Eb, G# = Ab, A# = Bb, (Cb = B, Fb = E, E# = F, B# = C)
