package org.example.myweb_backend.repository;

import org.example.myweb_backend.endpoints.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
