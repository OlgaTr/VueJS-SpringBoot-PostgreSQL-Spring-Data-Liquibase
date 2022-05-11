package com.spring.notes.controllers;

import com.spring.notes.services.NoteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @DeleteMapping("/notes/{noteId}")
    public void deleteNote(@PathVariable long noteId) {
        noteService.deleteNote(noteId);
    }
}
