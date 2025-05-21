package com.gametracker.gamertracker_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Esta clase será una tabla en la BD
public class Note {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    private String title; // Título de la  nota
    private String content; // Contenido de la nota

    // Constructor vacío
    public Note(){}

    // Constructor con todos los campos
    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    ///  Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
