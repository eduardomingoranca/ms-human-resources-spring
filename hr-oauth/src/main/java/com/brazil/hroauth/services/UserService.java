package com.brazil.hroauth.services;

import com.brazil.hroauth.feignclients.UserFeignClient;
import com.brazil.hroauth.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserFeignClient userFeignClient;

    public UserResponse findByEmail(String email) {
        /**
         * para buscar o usuário pelo email, é necessário
         * se comunicar com o microservice de usuários [hr-user]. */
        UserResponse userResponse = userFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(userResponse)) {
            LOGGER.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not Found");
        }
        LOGGER.info("Email found: " + email);
        return userResponse;
    }

}
