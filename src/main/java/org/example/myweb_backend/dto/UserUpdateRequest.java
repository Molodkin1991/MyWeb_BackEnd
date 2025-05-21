package org.example.myweb_backend.dto;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;
    private String password;
}
