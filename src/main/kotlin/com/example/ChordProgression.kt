package com.example
import com.example.Constants.VALID_KEYS
import com.example.Constants.VALID_SCALES

/*fun generateChordProgression(key: String, scale: String, length: Int): List<String> {
    // Your chord progression generation logic here
}*/

fun validateKey(key: String): Boolean {
    return key in VALID_KEYS
}

fun validateScale(scale: String): Boolean {
    return scale.lowercase() in VALID_SCALES
}
//TODO: Create data structure for properly transposing keys and giving their sharps and flats.
// enum equivalent? I II III IV V VI VII