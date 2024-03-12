package com.example

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*
import kotlinx.serialization.json.*



class ApplicationTest {
    private fun testGetScaleNotes(key: String, scale: String, expectedResponse: List<String>) = testApplication {

        val response = client.get("/scales/$key/$scale/notes")
        val jsonResponse = Json.decodeFromString<List<String>>(response.body())

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(expectedResponse, jsonResponse)
    }

    /**
     * test major scales
     */
    @Test
    fun testGetScaleNotes_C_Major() {
        testGetScaleNotes("C", "major", listOf("C", "D", "E", "F", "G", "A", "B"))
    }
    @Test
    fun testGetScaleNotes_G_Major() {
        testGetScaleNotes("G", "major", listOf("G", "A", "B", "C", "D", "E", "F#"))
    }
    @Test
    fun testGetScaleNotes_D_Major() {
        testGetScaleNotes("D", "major", listOf("D", "E", "F#", "G", "A", "B", "C#"))
    }

    @Test
    fun testGetScaleNotes_A_Major() {
        testGetScaleNotes("A", "major", listOf("A", "B", "C#", "D", "E", "F#", "G#"))
    }

    @Test
    fun testGetScaleNotes_E_Major() {
        testGetScaleNotes("E", "major", listOf("E", "F#", "G#", "A", "B", "C#", "D#"))
    }

    @Test
    fun testGetScaleNotes_B_Major() {
        testGetScaleNotes("B", "major", listOf("B", "C#", "D#", "E", "F#", "G#", "A#"))
    }
    @Test // Cb should become B
    fun testGetScaleNotes_Cb_Major() {
        testGetScaleNotes("Cflat", "major", listOf("B", "C#", "D#", "E", "F#", "G#", "A#"))
    }

    @Test
    fun testGetScaleNotes_Fsharp_Major() {
        testGetScaleNotes("Fsharp", "major", listOf("F#", "G#", "A#", "B", "C#", "D#", "E#"))
    }

    @Test
    fun testGetScaleNotes_F_Major() {
        testGetScaleNotes("F", "major", listOf("F", "G", "A", "Bb", "C", "D", "E"))
    }
    @Test // E# should become F
    fun testGetScaleNotes_Esharp_Major() {
        testGetScaleNotes("Esharp", "major", listOf("F", "G", "A", "Bb", "C", "D", "E"))
    }
    @Test
    fun testGetScaleNotes_Bb_Major() {
        testGetScaleNotes("Bflat", "major", listOf("Bb", "C", "D", "Eb", "F", "G", "A"))
    }
    @Test // A# should become Bb
    fun testGetScaleNotes_Asharp_Major() {
        testGetScaleNotes("Asharp", "major", listOf("Bb", "C", "D", "Eb", "F", "G", "A"))
    }

    @Test
    fun testGetScaleNotes_Eb_Major() {
        testGetScaleNotes("Eflat", "major", listOf("Eb", "F", "G", "Ab", "Bb", "C", "D"))
    }
    @Test // D# should become Eb
    fun testGetScaleNotes_Dsharp_Major() {
        testGetScaleNotes("Dsharp", "major", listOf("Eb", "F", "G", "Ab", "Bb", "C", "D"))
    }
    @Test
    fun testGetScaleNotes_Ab_Major() {
        testGetScaleNotes("Aflat", "major", listOf("Ab", "Bb", "C", "Db", "Eb", "F", "G"))
    }
    @Test // G# should become Ab
    fun testGetScaleNotes_Gsharp_Major() {
        testGetScaleNotes("Gsharp", "major", listOf("Ab", "Bb", "C", "Db", "Eb", "F", "G"))
    }

    @Test
    fun testGetScaleNotes_Db_Major() {
        testGetScaleNotes("Dflat", "major", listOf("Db", "Eb", "F", "Gb", "Ab", "Bb", "C"))
    }
    @Test // C# should become Db
    fun testGetScaleNotes_Csharp_Major() {
        testGetScaleNotes("Csharp", "major", listOf("Db", "Eb", "F", "Gb", "Ab", "Bb", "C"))
    }

    @Test
    fun testGetScaleNotes_Gb_Major() {
        testGetScaleNotes("Gflat", "major", listOf("Gb", "Ab", "Bb", "Cb", "Db", "Eb", "F"))
    }

    /**
     * test minor scales
     */
    @Test
    fun testGetScaleNotes_D_Minor() {
        testGetScaleNotes("D", "minor", listOf("D", "E", "F", "G", "A", "Bb", "C"))
    }

    @Test
    fun testGetScaleNotes_G_Minor() {
        testGetScaleNotes("G", "minor", listOf("G", "A", "Bb", "C", "D", "Eb", "F"))
    }

    @Test
    fun testGetScaleNotes_F_Minor() {
        testGetScaleNotes("F", "minor", listOf("F", "G", "Ab", "Bb", "C", "Db", "Eb"))
    }

    @Test
    fun testGetScaleNotes_Bb_Minor() {
        testGetScaleNotes("Bflat", "minor", listOf("Bb", "C", "Db", "Eb", "F", "Gb", "Ab"))
    }

    @Test // A# minor should be Bb minor
    fun testGetScaleNotes_Asharp_Minor() {
        testGetScaleNotes("Asharp", "minor", listOf("Bb", "C", "Db", "Eb", "F", "Gb", "Ab"))
    }
    @Test
    fun testGetScaleNotes_Eb_Minor() {
        testGetScaleNotes("Eflat", "minor", listOf("Eb", "F", "Gb", "Ab", "Bb", "Cb", "Db"))
    }

    @Test
    fun testGetScaleNotes_A_Minor() {
        testGetScaleNotes("A", "minor", listOf("A", "B", "C", "D", "E", "F", "G"))
    }

    @Test
    fun testGetScaleNotes_E_Minor() {
        testGetScaleNotes("E", "minor", listOf("E", "F#", "G", "A", "B", "C", "D"))
    }

    @Test // Fb minor should be E minor
    fun testGetScaleNotes_Fflat_Minor() {
        testGetScaleNotes("Fflat", "minor", listOf("E", "F#", "G", "A", "B", "C", "D"))
    }
    @Test
    fun testGetScaleNotes_B_Minor() {
        testGetScaleNotes("B", "minor", listOf("B", "C#", "D", "E", "F#", "G", "A"))
    }
    @Test // Cb minor should be B minor
    fun testGetScaleNotes_Cb_Minor() {
        testGetScaleNotes("Cflat", "minor", listOf("B", "C#", "D", "E", "F#", "G", "A"))
    }
    @Test
    fun testGetScaleNotes_Fsharp_Minor() {
        testGetScaleNotes("Fsharp", "minor", listOf("F#", "G#", "A", "B", "C#", "D", "E"))
    }
    @Test // Gb minor should be F# minor
    fun testGetScaleNotes_Gflat_Minor() {
        testGetScaleNotes("Gflat", "minor", listOf("F#", "G#", "A", "B", "C#", "D", "E"))
    }
    @Test
    fun testGetScaleNotes_Csharp_Minor() {
        testGetScaleNotes("Csharp", "minor", listOf("C#", "D#", "E", "F#", "G#", "A", "B"))
    }

    @Test // Db minor should be C# minor
    fun testGetScaleNotes_Db_Minor() {
        testGetScaleNotes("Dflat", "minor", listOf("C#", "D#", "E", "F#", "G#", "A", "B"))
    }
    @Test
    fun testGetScaleNotes_Gsharp_Minor() {
        testGetScaleNotes("Gsharp", "minor", listOf("G#", "A#", "B", "C#", "D#", "E", "F#"))
    }

    @Test // Ab minor should be G# minor
    fun testGetScaleNotes_Ab_Minor() {
        testGetScaleNotes("Aflat", "minor", listOf("G#", "A#", "B", "C#", "D#", "E", "F#"))
    }
}
//TODO: create tests for all major and minor scales, validate that the correct notes are returned.
// FIRST: create endpoints /scales/major and /scales/minor, return the list of notes for each key.
