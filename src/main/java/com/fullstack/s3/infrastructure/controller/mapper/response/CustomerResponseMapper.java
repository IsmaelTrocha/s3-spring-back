package com.fullstack.s3.infrastructure.controller.mapper.response;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.infrastructure.controller.dto.response.CustomerResponse;
import com.fullstack.s3.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerResponseMapper extends EntityToDto<Customer, CustomerResponse> {

}
