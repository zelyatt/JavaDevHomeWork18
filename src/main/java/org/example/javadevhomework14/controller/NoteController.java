package org.example.javadevhomework14.controller;

import jakarta.validation.Valid;
import org.example.javadevhomework14.model.Note;
import org.example.javadevhomework14.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNote(@RequestParam("id") Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note/edit";
    }

    @PostMapping("/edit")
    public String updateNote(@RequestParam("id") Long id,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content) {
        Note updateNote = new Note(id, title, content);
        noteService.update(updateNote);
        return "redirect:/note/list";
    }

    @GetMapping("/add")
    public String addNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "note/add";
    }

    @PostMapping("/add")
    public String addNote(@RequestParam("title") String title,
                          @RequestParam("content") String content) {
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return "redirect:/note/list";
    }
}
