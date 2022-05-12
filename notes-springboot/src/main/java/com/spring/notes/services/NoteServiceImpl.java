package com.spring.notes.services;

import com.spring.notes.repositories.NoteRepository;
import com.spring.notes.repositories.NotebookRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final NotebookRepository notebookRepository;

    public NoteServiceImpl(NoteRepository noteRepository, NotebookRepository notebookRepository) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository;
    }

    @Override
    public void deleteNote(long noteId) {
        noteRepository.deleteNote(noteId);
    }
}
