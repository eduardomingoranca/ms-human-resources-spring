package com.brazil.hroauth.resources;

import com.brazil.hroauth.responses.UserResponse;
import com.brazil.hroauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserResources {

    private final UserService userService;

    @GetMapping(value = "/search")
    public ResponseEntity<UserResponse> findByEmail(@RequestParam String email) {
        try {
            UserResponse userResponse = userService.findByEmail(email);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
