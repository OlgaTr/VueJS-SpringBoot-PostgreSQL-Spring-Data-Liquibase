package com.spring.notes.services;

import com.spring.notes.entities.Note;
import com.spring.notes.repositories.NoteRepository;
import com.spring.notes.repositories.NotebookRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final NotebookRepository notebookRepository;

    public NoteServiceImpl(NoteRepository noteRepository, NotebookRepository notebookRepository) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository;
    }

    @Override
    public void addNote(String username, Note note) {
        String title = note.title();
        String content = note.content();
        LocalDate date = LocalDate.now();
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        long notebookId = notebookRepository.findNotebookByUsername(username).notebookId();
        noteRepository.addNote(notebookId, title, content, timestamp);
    }

    @Override
    public Note getNote(long noteId) {
        return noteRepository.getNoteById(noteId);
    }

    @Override
    public void deleteNote(long noteId) {
        noteRepository.deleteNote(noteId);
    }

    @Override
    public List<Note> listNotes(String username) {
        List<Note> notes = noteRepository.findNotes(username);
        return notes;
    }
}
