package com.brazil.hrpayroll.feignclients;

import com.brazil.hrpayroll.responses.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001/api/v1", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(path = "/{id}")
    ResponseEntity<WorkerResponse> findById(@PathVariable long id);
}
