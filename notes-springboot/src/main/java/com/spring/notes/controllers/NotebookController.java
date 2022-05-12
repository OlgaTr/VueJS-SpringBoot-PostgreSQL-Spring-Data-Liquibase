package com.spring.notes.controllers;

import com.spring.notes.entities.Note;
import com.spring.notes.services.NotebookService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
public class NotebookController {
    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping(value = "/notebooks/notes")
    public List<Note> listNotes(Principal principal) {
        String username = principal.getName();
        long notebookId = notebookService.getNotebook(username).id();
        List<Note> notes = notebookService.listNotes(notebookId);
        System.out.println(notes);
        return notes;
    }

    @PostMapping("/notebooks/notes")
    public void addNote(Principal principal, @RequestBody Note note) {
        String username = principal.getName();
        long notebookId = notebookService.getNotebook(username).id();
        notebookService.addNote(notebookId, note);
    }
}
