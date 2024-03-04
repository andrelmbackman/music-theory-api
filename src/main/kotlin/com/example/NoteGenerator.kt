package com.example

import com.example.Constants.SHARP_NOTESET
import com.example.Constants.FLAT_NOTESET
import com.example.Constants.MAJOR_KEY_CONTAINS_SHARP
import com.example.Constants.MAJOR_TONES_INDEXES
import com.example.Constants.MINOR_KEY_CONTAINS_SHARP
import com.example.Constants.MINOR_TONES_INDEXES
import io.ktor.http.*

/**
 * This is a node in a circular linked list.
 */
class CircularListNode<T>(val value: T) {
    var next: CircularListNode<T>? = null
}

/**
 * Circular linked list to represent and retrieve notes of a key/scale.
 */
class CircularList<String> {
    private var head: CircularListNode<String>? = null

    fun add(value: String) {
        val newNode = CircularListNode(value)
        if (head == null) {
            head = newNode
            head?.next = head
        } else {
            var current = head
            while (current?.next != head) {
                current = current?.next
            }
            current?.next = newNode
            newNode.next = head
        }
    }

    fun shiftToKey(note: String) {
        var current = head
        while (current?.value != note) {
            current = current?.next
            if (current == head)
                break
        }
        head = current
    }

    fun getNotes(): List<String> {
        val notes = mutableListOf<String>()
        var currentNode = head
        if (currentNode != null) {
            do {
                currentNode?.value?.let {
                    notes.add(it)
                }
                currentNode = currentNode?.next
            } while (currentNode != head)
        }
        return notes
    }

    fun getMajorNotes(): List<String> {
        val notes = mutableListOf<String>()
        var index = 1

        var currentNode = head
        while (notes.size < MAJOR_TONES_INDEXES.size) {
            if (index in MAJOR_TONES_INDEXES) {
                currentNode?.value?.let { notes.add(it) }
            }
            currentNode = currentNode?.next
            index++
        }
        return (notes)
    }

    fun getMinorNotes(): List<String> {
        val notes = mutableListOf<String>()
        var index = 1

        var currentNode = head
        while (notes.size < MINOR_TONES_INDEXES.size) {
            if (index in MINOR_TONES_INDEXES)
                currentNode?.value?.let {notes.add(it) }
            currentNode = currentNode?.next
            index++
            if (index > 13)
                break
        }
        return (notes)
    }

    fun print() {
        var current = head
        if (current != null) {
            do {
                println(current?.value)
                current = current?.next
            } while (current != head)
        }
    }
}

class NoteGenerator {
    /**
     * Returns the appropriate set of 12 tones, depending on if the key and scale contains sharps or flats.
     */
    fun getNoteSet(key: String, scale: String): Set<String> {
        return if (scale == "major") {
            if (key in MAJOR_KEY_CONTAINS_SHARP)
                SHARP_NOTESET
            else
                FLAT_NOTESET
        }
        else {
            if (key in MINOR_KEY_CONTAINS_SHARP)
                SHARP_NOTESET
            else
                FLAT_NOTESET
        }
    }

    /**
     * Change keys to use the appropriate key for the scale.
     */
    fun switchKeyToLeastSignatures(key: String, scale: String): String {
        return when {
            scale.equals("major", ignoreCase = true) -> {
                when (key) {
                    "E#" -> "F"
                    "A#" -> "Bb"
                    "D#" -> "Eb"
                    "G#" -> "Ab"
                    "C#" -> "Db"
                    "Cb" -> "B"
                    "Fb" -> "E"
                    "B#" -> "C"
                    else -> key
                }
            }
            scale.equals("minor", ignoreCase = true) -> {
                when (key) {
                    "Db" -> "C#"
                    "Gb" -> "F#"
                    "Cb" -> "B"
                    "Fb" -> "E"
                    "E#" -> "F"
                    "A#" -> "Bb"
                    "Ab" -> "G#"
                    else -> key
                }
            }
            else -> key
        }
    }

    /**
     * Returns the notes of a given key and scale.
     */
    fun getNotes(key: String, scale: String): List<String> {
        val newKey: String = switchKeyToLeastSignatures(key, scale)
        val noteSet = getNoteSet(newKey, scale)
        val noteList = CircularList<String>()
        noteSet.forEach { noteList.add(it) }
        noteList.shiftToKey(newKey)
        noteList.print()
        return if (scale == "major")
            noteList.getMajorNotes()
        else
            noteList.getMinorNotes()
    }

}