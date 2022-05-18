package com.spring.notes.services;

import com.spring.notes.entities.Note;

import java.util.List;

public interface NoteService {
    Note getNote(long noteId);
    void addNote(String username, Note note);
    void deleteNote(long noteId);
    List<Note> listNotes(String username);
}
