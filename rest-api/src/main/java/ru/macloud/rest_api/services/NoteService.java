package ru.macloud.rest_api.services;

import ru.macloud.rest_api.entities.Note;

import java.util.List;

public interface NoteService {

    List<Note> findAllNotesOrTrown();
    Note findNoteByIdOrTrown(Long id);
    Note createNote(Note note);
    Note deleteNoteByIdOrTrown(Long id);

    Note updateNoteOrTrown(Note note);

}
