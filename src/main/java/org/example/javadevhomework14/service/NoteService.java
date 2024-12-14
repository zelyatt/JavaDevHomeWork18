package org.example.javadevhomework14.service;


import lombok.AllArgsConstructor;
import org.example.javadevhomework14.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class NoteService {

    private final List<Note> notes = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Note> listAll() {
        return new ArrayList<>(notes);
    }

    public Note add(Note note) {
        note.setId(idGenerator.getAndIncrement());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        notes.removeIf(note -> note.getId() == id);
    }

    public void update(Note note) {
        Optional<Note> optionalNote = notes.stream()
                .filter(n -> n.getId().equals(note.getId()))
                .findFirst();
        if (optionalNote.isPresent()) {
            optionalNote.get().setTitle(note.getTitle());
            optionalNote.get().setContent(note.getContent());
        } else {
            throw new IllegalArgumentException("Note not found");
        }
    }

    public Note getById(long id) {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }
}
