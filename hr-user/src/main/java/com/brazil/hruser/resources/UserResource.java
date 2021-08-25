package com.brazil.hruser.resources;

import com.brazil.hruser.responses.UserResponse;
import com.brazil.hruser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable long id) {
        return new ResponseEntity(userService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<UserResponse> findByEmail(@RequestParam String email) {
        return new ResponseEntity(userService.findByEmail(email), HttpStatus.OK);
    }

}
