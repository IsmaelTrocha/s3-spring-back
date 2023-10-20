package com.fullstack.s3.infrastructure.controller.mapper.request;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.infrastructure.controller.dto.request.CustomerRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-20T15:23:05-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class CustomerRequestMapperImpl implements CustomerRequestMapper {

    @Override
    public CustomerRequest toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerRequest customerRequest = new CustomerRequest();

        return customerRequest;
    }

    @Override
    public Customer toEntity(CustomerRequest toDto) {
        if ( toDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }

    @Override
    public List<CustomerRequest> toDto(List<Customer> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CustomerRequest> list = new ArrayList<CustomerRequest>( entity.size() );
        for ( Customer customer : entity ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> toEntity(List<CustomerRequest> toDto) {
        if ( toDto == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( toDto.size() );
        for ( CustomerRequest customerRequest : toDto ) {
            list.add( toEntity( customerRequest ) );
        }

        return list;
    }
}
