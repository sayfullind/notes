package ru.macloud.rest_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.macloud.rest_api.entities.Note;
import ru.macloud.rest_api.services.NoteService;

import java.util.List;

@RestController
@RequestMapping("${app.note-rest-mapping}")
@RequiredArgsConstructor
public final class NoteRestController {

    private final NoteService service;

    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        return ResponseEntity.ok(service.findAllNotesOrTrown());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findNoteByIdOrTrown(id));
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.ok(service.createNote(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNoteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.deleteNoteByIdOrTrown(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNoteById(@RequestBody Note note) {
        return ResponseEntity.ok(service.updateNoteOrTrown(note));
    }
}
