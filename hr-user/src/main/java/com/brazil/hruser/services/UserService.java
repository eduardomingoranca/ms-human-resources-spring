package com.brazil.hruser.services;

import com.brazil.hruser.exceptions.BadRequestException;
import com.brazil.hruser.mappers.UserMapper;
import com.brazil.hruser.repositories.UserRepository;
import com.brazil.hruser.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse findByIdOrThrowBadRequestException(long id) {
        return UserMapper.INSTANCE.toWorkerResponse(userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not Found")));
    }

    public UserResponse findByEmail(String email) {
        return UserMapper.INSTANCE.toWorkerResponse(userRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Email not Found")));
    }
}
