package com.gametracker.gamertracker_backend.controller;

import com.gametracker.gamertracker_backend.model.Note;
import com.gametracker.gamertracker_backend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Declara que esta clase es un controlador REST
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired //Spring se encarga de crear una instancia de NoteRepository y asignarla
    private NoteRepository noteRepository; // Nos permite acceder a la base de datos (buscar, guardar, etc.)

    @GetMapping // Maneja peticiones GET a /api/note
    public List<Note> getAllNotes() {
        return noteRepository.findAll(); // Devuelve todas las notas al frontend (o Postman) de la BD
    }

    @PostMapping // Maneja peticiones POST a /api/notes
    public Note createNote(@RequestBody Note note) { // @RequestBody se encarga de mapear un JSON a un objeto de tipo Note
        return noteRepository.save(note);
    }

    // Obtener una nota por id
    @GetMapping("/{id}") // Maneja peticiones GET a /api/notes/{id}
    public Note getNoteById(@PathVariable Long id) { // @PathVariable extrae el valor del ide desde la URL
        Optional<Note> optionalNote = noteRepository.findById(id); // Busca si existe una nota con ese id, de lo contrario devuelve null

        // Si la nota existe..
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            // Si no existe lanzamos un error.
            throw new RuntimeException("No encontrada la id: " + id);
        }
    }

    // Actualizar una nota
    @PutMapping("/{id}") // Maneja peticiones PUT a /api/notes/{id}
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        //@PathVariable extraer el valor del ID desde la URL.
        //@RequestBody convierte el cuerpo de la petición en un objeto de tipo Note.

        Optional<Note> optionalNote = noteRepository.findById(id); // Busca si existe una nota con ese id, de lo contrario devuelve un Optional vacío.

        if (optionalNote.isPresent()) { // Si la nota existe...
            Note note = optionalNote.get(); // La obtenemos desde el Optional

            note.setTitle(updatedNote.getTitle()); // Actualizamos el título
            note.setContent(updatedNote.getContent()); // Actualizamos el contenido

            return noteRepository.save(note); // Guardamos los cambios y devolvemos la nota modificada.

        } else {
            // Si no existe lanzamos un error.
            throw new RuntimeException("Nota no encontrada con id: " + id);
        }
    }

    // Borrar una nota
    @DeleteMapping("/{id}")// Maneja peticiones DELETE a /api/notes/{id}
    public String deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id); // Elimina la nota con ese ID de la base de datos.

        return "Nota eliminada correctamente!";
    }



    /**
     * ENDPOINT PRUEBA API READY
     */
    @GetMapping("/ping")
    public String ping() {
        return "API corriendo modo god.🚀";
    }
}
