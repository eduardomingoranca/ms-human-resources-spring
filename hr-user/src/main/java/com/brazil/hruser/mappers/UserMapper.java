package com.brazil.hruser.mappers;

import com.brazil.hruser.entities.User;
import com.brazil.hruser.responses.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    /**
     * criando uma instancia de mapper*/
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * convertendo automaticamente todos os
     * atributos dentro das DTO's
     *
     * @param user
     */
    public abstract UserResponse toWorkerResponse(User user);
}
