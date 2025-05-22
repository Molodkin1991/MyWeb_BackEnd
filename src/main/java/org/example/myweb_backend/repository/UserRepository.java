package org.example.myweb_backend.repository;

import org.example.myweb_backend.endpoints.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByUsername(String username);

    Optional<User> findByUsername(String username);
}
