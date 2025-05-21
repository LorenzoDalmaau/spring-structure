package com.gametracker.gamertracker_backend.repository;

import com.gametracker.gamertracker_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
