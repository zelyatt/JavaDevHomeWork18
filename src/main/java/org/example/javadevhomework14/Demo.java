package org.example.javadevhomework14;

import org.example.javadevhomework14.model.Note;
import org.example.javadevhomework14.service.NoteService;

public class Demo {
    public static void main(String[] args) {
        NoteService noteService = new NoteService();

        Note note = new Note(1L, "First title", "First content");
        Note note2 = new Note(2L, "Second title", "Second content");

        noteService.add(note);
        noteService.add(note2);

        noteService.listAll().forEach(System.out::println);

        note.setTitle("Another title");
        note.setContent("Another content");
        noteService.update(note);

        noteService.listAll().forEach(System.out::println);


        System.out.println(noteService.getById(1L));

        noteService.deleteById(2L);
        noteService.listAll().forEach(System.out::println);

    }
}
