package ru.macloud.rest_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.macloud.rest_api.entities.Note;


@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {}