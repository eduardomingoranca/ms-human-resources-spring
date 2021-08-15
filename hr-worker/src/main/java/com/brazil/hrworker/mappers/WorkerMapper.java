package com.brazil.hrworker.mappers;

import com.brazil.hrworker.entities.Worker;
import com.brazil.hrworker.responses.WorkerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class WorkerMapper {
    // criando uma instancia
    public static final WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    /**
     * convertendo automaticamente todos os
     * atributos dentro das DTO's
     *
     * @param workers
     */
    public abstract List<WorkerResponse> toWorkersResponse(List<Worker> workers);
    public abstract WorkerResponse toWorkerResponse(Worker worker);
}
