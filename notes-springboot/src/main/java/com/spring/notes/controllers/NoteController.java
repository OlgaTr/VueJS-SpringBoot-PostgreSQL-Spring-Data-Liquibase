package com.spring.notes.controllers;

import com.spring.notes.entities.Note;
import com.spring.notes.services.NoteService;
import com.spring.notes.services.NotebookService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
public class NoteController {
    private final NoteService noteService;
    private final NotebookService notebookService;

    public NoteController(NoteService noteService, NotebookService notebookService) {
        this.noteService = noteService;
        this.notebookService = notebookService;
    }

    @PostMapping("/notebooks/notes")
    public void addNote(Principal principal, @RequestBody Note note) {
        String username = principal.getName();
        noteService.addNote(username, note);
    }

    @GetMapping("/notes/{noteId}")
    public Note getNote(@PathVariable long noteId) {
        return noteService.getNote(noteId);
    }

    @DeleteMapping("/notes/{noteId}")
    public void deleteNote(@PathVariable long noteId) {
        noteService.deleteNote(noteId);
    }

    @PutMapping("/notes/{noteId}")
    public void updateNote(@RequestBody Note note, @PathVariable long noteId) {

    }

    @GetMapping(value = "/notebooks/notes")
    public List<Note> listNotes(Principal principal) {
        String username = principal.getName();
        List<Note> notes = noteService.listNotes(username);
        return notes;
    }

}
