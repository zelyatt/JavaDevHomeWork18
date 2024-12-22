package org.example.javadevhomework14.service;


import lombok.RequiredArgsConstructor;
import org.example.javadevhomework14.model.Note;
import org.example.javadevhomework14.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        Note existingNote = noteRepository.findById(note.getId())
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        noteRepository.save(existingNote);
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }
}
