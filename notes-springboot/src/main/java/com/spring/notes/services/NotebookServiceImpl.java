package com.spring.notes.services;

import com.spring.notes.entities.Note;
import com.spring.notes.entities.Notebook;
import com.spring.notes.repositories.NoteRepository;
import com.spring.notes.repositories.NotebookRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class NotebookServiceImpl implements NotebookService{
    private final NotebookRepository notebookRepository;
    private final NoteRepository noteRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository, NoteRepository noteRepository) {
        this.notebookRepository = notebookRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public Notebook getNotebook(String username) {
        return notebookRepository.findNotebookByUsername(username);
    }

    @Override
    public void addNote(long notebookId, Note note) {
        String title = note.title();
        String content = note.content();
        LocalDate date = LocalDate.now();
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        noteRepository.addNote(notebookId, title, content, timestamp);
    }

    @Override
    public List<Note> listNotes(long notebookId) {
        List<Note> notes = notebookRepository.findNotes(notebookId);
        return notes;
    }
}
