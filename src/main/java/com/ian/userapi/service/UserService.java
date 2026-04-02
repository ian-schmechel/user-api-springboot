package com.ian.userapi.service;

import com.ian.userapi.dto.UserRequestDTO;
import com.ian.userapi.dto.UserResponseDTO;
import com.ian.userapi.entity.User;
import com.ian.userapi.exception.EmailAlreadyExistsException;
import com.ian.userapi.exception.UserNotFoundException;
import com.ian.userapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        userRepository.findByEmail(dto.getEmail()).ifPresent(user -> {
            throw new EmailAlreadyExistsException("Email já cadastrado");
        });

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        return toResponseDTO(savedUser);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        return toResponseDTO(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User updatedUser = userRepository.save(user);

        return toResponseDTO(updatedUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        userRepository.delete(user);
    }

    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}