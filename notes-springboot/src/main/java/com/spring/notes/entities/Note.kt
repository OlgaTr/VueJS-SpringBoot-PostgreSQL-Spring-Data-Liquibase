package com.spring.notes.entities

import java.time.LocalDate

data class Note(val noteId: Long, val title: String?, val content: String?, val date: LocalDate?){
    fun noteId(): Long {
        return noteId;
    }

    fun content(): String? {
        return content;
    }

    fun title(): String? {
        return title;
    }
}