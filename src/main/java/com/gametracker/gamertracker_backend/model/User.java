package com.gametracker.gamertracker_backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental
    private Long id;

    @Column(nullable = false)
    private String username; // Nombre visible del usuario

    @Column(unique = true, nullable = false)
    private String email; // Email único usado para iniciar sesión

    @Column(nullable = false)
    private String password; // Contraseña del usuario

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Fecha de creación

    // Constructor para JPA
    public User() {}

    // Constructor con todos los atributos
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
