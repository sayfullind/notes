package ru.macloud.rest_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.macloud.rest_api.entities.Note;


@RepositoryRestResource
public interface NoteRepository extends CrudRepository<Note, Long> {}