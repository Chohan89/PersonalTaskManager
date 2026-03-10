package com.ptm.personaltaskmanager.mapper;

import org.mapstruct.Mapper;

import com.ptm.personaltaskmanager.dto.CreateAccountRequest;
import com.ptm.personaltaskmanager.dto.CreateAccountResponse;
import com.ptm.personaltaskmanager.model.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users toEntity(CreateAccountRequest request);

    CreateAccountResponse toResponse(Users user);
}
