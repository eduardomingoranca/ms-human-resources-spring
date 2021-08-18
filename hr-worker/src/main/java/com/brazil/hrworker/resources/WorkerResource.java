package com.brazil.hrworker.resources;

import com.brazil.hrworker.responses.WorkerResponse;
import com.brazil.hrworker.services.WorkerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/workers")
@RequiredArgsConstructor
public class WorkerResource {

    private static Logger LOGGER = LoggerFactory.getLogger(WorkerResource.class);

    private final WorkerService workerService;
    private final Environment environment;

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> list() {
        return new ResponseEntity(workerService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<WorkerResponse> findById(@PathVariable long id) {

        /* try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        LOGGER.info("PORT = " + environment.getProperty("local.server.port"));
        return new ResponseEntity(workerService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }

}
