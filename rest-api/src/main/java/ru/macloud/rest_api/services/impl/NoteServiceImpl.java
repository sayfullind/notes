package ru.macloud.rest_api.services.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.macloud.rest_api.entities.Note;
import ru.macloud.rest_api.exceptions.NoteNotFoundException;
import ru.macloud.rest_api.repositories.NoteRepository;
import ru.macloud.rest_api.services.NoteService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    @Override
    public List<Note> findAllNotesOrTrown() {
        final var list = (List<Note>) repository.findAll();

        if (list.isEmpty())
            throw new NoteNotFoundException("No notes found.");

        return list;
    }

    @Override
    public Note findNoteByIdOrTrown(Long id) {
        final var note = repository.findById(id);

        if (note.isEmpty())
            throw new NoteNotFoundException(id);

        return note.get();
    }

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public Note deleteNoteByIdOrTrown(Long id) {
        final var note = repository.findById(id);

        if (note.isEmpty())
            throw new NoteNotFoundException(id);

        repository.deleteById(id);
        return note.get();
    }

    @Override
    public Note updateNoteOrTrown(Note note) {
        final var exist = repository.existsById(note.getId());

        if (!exist)
            throw new NoteNotFoundException(note.getId());

        return repository.save(note);
    }
}