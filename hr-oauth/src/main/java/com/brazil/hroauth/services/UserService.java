package com.brazil.hroauth.services;

import com.brazil.hroauth.entities.User;
import com.brazil.hroauth.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
/**
 * UserDetailsService >> é uma interface que o spring security utiliza para buscar o usuário
 * pelo username no banco de dados, e ao buscar esse usuário no banco de dados e compara as senhas.*/
public class UserService implements UserDetailsService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserFeignClient userFeignClient;

   /**
    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(user)) {
            LOGGER.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not Found");
        }
        LOGGER.info("Email found: " + email);
        return user;
    } */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * para buscar o usuário pelo email, é necessário
         * se comunicar com o microservice de usuários [hr-user]. */
        User user = userFeignClient.findByEmail(username).getBody();

        if (Objects.isNull(user)) {
            LOGGER.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not Found");
        }
        LOGGER.info("Email found: " + username);

        return user;
    }
}
