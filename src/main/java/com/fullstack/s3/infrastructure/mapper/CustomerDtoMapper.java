package com.fullstack.s3.infrastructure.mapper;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.infrastructure.repository.CustomerDto;
import com.fullstack.s3.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerDtoMapper extends EntityToDto<Customer, CustomerDto> {

}
