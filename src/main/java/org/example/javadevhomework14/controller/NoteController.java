package org.example.javadevhomework14.controller;

import jakarta.validation.Valid;
import org.example.javadevhomework14.model.Note;
import org.example.javadevhomework14.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.listAll();
    }

    @PostMapping
    public Note createNote(@RequestBody @Valid Note note) {
        return noteService.add(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody @Valid Note note) {
        note.setId(id);
        return noteService.update(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
    }
}
