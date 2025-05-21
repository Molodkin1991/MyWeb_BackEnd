package org.example.myweb_backend.dto;

import lombok.Data;

import java.util.List;
@Data
public class PostDTO {
    private Long id;
    private String content;
    private Long ownerId;
    private List<String> comments;
}