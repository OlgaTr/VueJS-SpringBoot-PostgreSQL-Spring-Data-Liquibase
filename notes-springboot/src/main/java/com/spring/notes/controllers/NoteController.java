package com.spring.notes.controllers;

import com.spring.notes.records.Note;
import com.spring.notes.services.NoteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping("/notes")
    public List<Note> listAll() {
        return service.findAll();
    }
}
