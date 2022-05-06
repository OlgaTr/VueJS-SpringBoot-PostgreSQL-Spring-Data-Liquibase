package com.spring.notes.services;

import com.spring.notes.entities.Note;
import com.spring.notes.entities.Notebook;
import com.spring.notes.repositories.NoteRepository;
import com.spring.notes.repositories.NotebookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NotebookServiceImpl implements NotebookService{
    private final NotebookRepository notebookRepository;
    private final NoteRepository noteRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository, NoteRepository noteRepository) {
        this.notebookRepository = notebookRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public void addNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    @Override
    public void addNote(long notebookId, Note note) {
        String title = note.getTitle();
        String content = note.getContent();
        Date date = note.getDate();
        noteRepository.addNote(notebookId, title, content, date);
    }

    @Override
    public List<Note> listNotes(long notebookId) {
        List<Note> notes = notebookRepository.findNotes(notebookId);
        return notes;
    }
}
