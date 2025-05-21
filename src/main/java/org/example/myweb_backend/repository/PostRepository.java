package org.example.myweb_backend.repository;

import org.example.myweb_backend.endpoints.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
