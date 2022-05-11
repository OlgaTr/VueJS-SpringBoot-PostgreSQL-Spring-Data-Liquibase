package com.spring.notes.controllers;

import com.spring.notes.entities.Note;
import com.spring.notes.entities.Notebook;
import com.spring.notes.services.NotebookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class NotebookController {
    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping(value = "/notebooks/{notebookId}/notes")
    public List<Note> listNotes(@PathVariable long notebookId) {
        List<Note> notes = notebookService.listNotes(notebookId);
        System.out.println(notes);
        return notes;
    }

    @PostMapping("/notebooks/{notebookId}/notes")
    public void addNote(@PathVariable long notebookId, @RequestBody Note note) {
        notebookService.addNote(notebookId, note);
    }

    @PostMapping("/notebooks")
    public void addNotebook(@RequestBody Notebook notebook) {
        notebookService.addNotebook(notebook);
    }

}
