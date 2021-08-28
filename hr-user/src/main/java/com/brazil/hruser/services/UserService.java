package com.brazil.hruser.services;

import com.brazil.hruser.entities.User;
import com.brazil.hruser.exceptions.BadRequestException;
import com.brazil.hruser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByIdOrThrowBadRequestException(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not Found"));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Email not Found"));
    }
}
