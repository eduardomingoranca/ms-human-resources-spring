package com.brazil.hrworker.services;

import com.brazil.hrworker.exceptions.BadRequestException;
import com.brazil.hrworker.mappers.WorkerMapper;
import com.brazil.hrworker.repositories.WorkerRepository;
import com.brazil.hrworker.responses.WorkerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<WorkerResponse> listAll() {
        return WorkerMapper.INSTANCE.toWorkersResponse(workerRepository.findAll());
    }

    public WorkerResponse findByIdOrThrowBadRequestException(long id) {
        return WorkerMapper.INSTANCE.toWorkerResponse(workerRepository.findById(id)
        .orElseThrow(() -> new BadRequestException("Worker not Found")));
    }
}
