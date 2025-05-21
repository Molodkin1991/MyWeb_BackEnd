package org.example.myweb_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.myweb_backend.dto.PostCreateRequest;
import org.example.myweb_backend.dto.PostDTO;
import org.example.myweb_backend.dto.PostUpdateRequest;
import org.example.myweb_backend.endpoints.Post;
import org.example.myweb_backend.endpoints.User;
import org.example.myweb_backend.exeption.NotFoundException;
import org.example.myweb_backend.repository.PostRepository;
import org.example.myweb_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDTO create(Long userId, PostCreateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        Post post = new Post();
        post.setContent(request.getContent());
        post.setOwner(user);

        post = postRepository.save(post);

        return toDTO(post);
    }

    public PostDTO update(Long postId, PostUpdateRequest request) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));
        post.setContent(request.getContent());

        post = postRepository.save(post);

        return toDTO(post);
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    public void addComment(Long postId, String comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));
        post.getComments().add(comment);
        postRepository.save(post);
    }

    private PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setContent(post.getContent());
        dto.setOwnerId(post.getOwner().getId());
        dto.setComments(post.getComments());
        return dto;
    }
}