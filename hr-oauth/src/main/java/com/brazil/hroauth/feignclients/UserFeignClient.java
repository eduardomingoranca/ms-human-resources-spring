package com.brazil.hroauth.feignclients;

import com.brazil.hroauth.responses.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/api/v1/users")
public interface UserFeignClient {

    /**
     * assinatura de metodos*/
    @GetMapping(path = "/search")
    ResponseEntity<UserResponse> findByEmail(@RequestParam String email);
}
