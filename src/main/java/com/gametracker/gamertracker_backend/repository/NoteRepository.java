package com.gametracker.gamertracker_backend.repository;

import com.gametracker.gamertracker_backend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // No es necesario escribir nada extra. Hereda métodos de JpaRepository
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
}
