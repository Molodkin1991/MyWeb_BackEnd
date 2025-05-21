package org.example.myweb_backend.services;

import lombok.RequiredArgsConstructor;
import org.example.myweb_backend.dto.UserCreateRequest;
import org.example.myweb_backend.dto.UserDTO;
import org.example.myweb_backend.dto.UserUpdateRequest;
import org.example.myweb_backend.endpoints.User;
import org.example.myweb_backend.exeption.NotFoundException;
import org.example.myweb_backend.mapers.UserMapper;
import org.example.myweb_backend.repository.UserRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO create(UserCreateRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        user = userRepository.save(user);

        return toDTO(user);
    }

    public UserDTO update(Long id, UserUpdateRequest req) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        if (req.getName() != null) user.setName(req.getName());
        if (req.getPassword() != null) user.setPassword(passwordEncoder.encode(req.getPassword()));

        user = userRepository.save(user);

        return toDTO(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setName(user.getName());
        dto.setRole(user.getRole());
        return dto;
    }
}
