package com.spring.notes.controllers;

import com.spring.notes.entities.Note;
import com.spring.notes.services.NoteService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/notes/{noteId}")
    public void updateNote(@RequestBody Note note, @PathVariable long noteId) {

    }

}
