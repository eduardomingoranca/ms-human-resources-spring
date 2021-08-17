package com.brazil.hrpayroll.feignclients;

import com.brazil.hrpayroll.responses.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/api/v1/workers")
public interface WorkerFeignClient {

    @GetMapping(path = "/{id}")
    ResponseEntity<WorkerResponse> findById(@PathVariable long id);
}
