package com.spring.notes.services;

import com.spring.notes.entities.Note;
import com.spring.notes.entities.Notebook;

import java.util.List;

public interface NotebookService {
    void addNotebook(Notebook notebook);
    void addNote(long notebookId, Note note);
    List<Note> listNotes(long notebookId);
}
