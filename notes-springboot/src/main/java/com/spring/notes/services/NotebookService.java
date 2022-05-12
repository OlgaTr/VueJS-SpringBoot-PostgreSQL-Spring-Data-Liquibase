package com.spring.notes.services;

import com.spring.notes.entities.Note;
import com.spring.notes.entities.Notebook;

import java.util.List;

public interface NotebookService {
    Notebook getNotebook(String username);
    void addNote(long notebookId, Note note);
    List<Note> listNotes(long notebookId);
}
