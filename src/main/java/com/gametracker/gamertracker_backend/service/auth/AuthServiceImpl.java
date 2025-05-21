package com.gametracker.gamertracker_backend.service.auth;

import com.gametracker.gamertracker_backend.dto.AuthRequest;
import com.gametracker.gamertracker_backend.dto.AuthResponse;
import com.gametracker.gamertracker_backend.model.User;
import com.gametracker.gamertracker_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encripta la contraseña
        return userRepository.save(user); // Guarda el usuario en BD
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        // Buscamos usuario por Email.
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Condición para comprobar si las constraseñas coinciden
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // Generamos el Token mediante el email
        String token = jwtUtil.generateToken(user.getEmail());

        // Enviamos al front al Controller el email.
        return new AuthResponse(token);
    }
}