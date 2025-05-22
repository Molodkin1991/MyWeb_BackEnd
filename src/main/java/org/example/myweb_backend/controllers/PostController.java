package org.example.myweb_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.example.myweb_backend.dto.PostCreateRequest;
import org.example.myweb_backend.dto.PostDTO;
import org.example.myweb_backend.dto.PostUpdateRequest;
import org.example.myweb_backend.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAll() {
        List<PostDTO> posts =new ArrayList<PostDTO>();
        posts =  postService.getAll();
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<PostDTO> create(@PathVariable Long userId, @RequestBody PostCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(userId, request));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> update(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        return ResponseEntity.ok(postService.update(postId, request));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{postId}/comment")
    public ResponseEntity<Void> comment(@PathVariable Long postId, @RequestBody String comment) {
        postService.addComment(postId, comment);
        return ResponseEntity.ok().build();
    }
}
