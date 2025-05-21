package org.example.myweb_backend.dto;


import lombok.Data;
import org.example.myweb_backend.endpoints.Role;
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String name;
    private Role role;
}
