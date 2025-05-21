package org.example.myweb_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.myweb_backend.endpoints.Role;
@Data
public class UserCreateRequest {
        @NotBlank
        private String username;

        @NotBlank
        private String name;

        @Size(min = 6)
        private String password;

        private Role role;

}
