package com.ptm.personaltaskmanager.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.ptm.personaltaskmanager.dto.CreateTaskRequest;
import com.ptm.personaltaskmanager.dto.CreateTaskResponse;
import com.ptm.personaltaskmanager.dto.ReadTasksResponse;
import com.ptm.personaltaskmanager.dto.TaskDto;
import com.ptm.personaltaskmanager.dto.UpdateTaskRequest;
import com.ptm.personaltaskmanager.model.Tasks;


@Mapper(componentModel = "spring")
public interface TaskMapper {

	// Create
    Tasks toEntity(CreateTaskRequest request);
    CreateTaskResponse toResponse(Tasks task);

    // Read
    TaskDto toDto(Tasks task);
    List<TaskDto> toDtoList(List<Tasks> tasks);

    // Update (partial)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTaskFromRequest(UpdateTaskRequest request, @MappingTarget Tasks task);

}