package com.gametracker.gamertracker_backend.service.auth;

import com.gametracker.gamertracker_backend.dto.AuthRequest;
import com.gametracker.gamertracker_backend.dto.AuthResponse;
import com.gametracker.gamertracker_backend.model.User;

/**
 * Service es el encargado de toda la lógica de negocio de nuestro backend.
 * En este caso, enfocada a la parte de autentificación.
 */

public interface AuthService {
    User register(User user);
    AuthResponse login (AuthRequest request);
}

