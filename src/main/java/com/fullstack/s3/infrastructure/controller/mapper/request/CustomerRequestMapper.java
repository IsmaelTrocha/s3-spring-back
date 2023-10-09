package com.fullstack.s3.infrastructure.controller.mapper.request;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.infrastructure.controller.dto.request.CustomerRequest;
import com.fullstack.s3.shared.mapper.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerRequestMapper extends EntityToDto<Customer, CustomerRequest> {

}
