package com.fullstack.s3.infrastructure.controller.mapper.response;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.infrastructure.controller.dto.response.CustomerResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-20T14:41:06-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class CustomerResponseMapperImpl implements CustomerResponseMapper {

    @Override
    public CustomerResponse toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId( entity.getId() );
        customerResponse.setName( entity.getName() );
        customerResponse.setEmail( entity.getEmail() );
        customerResponse.setPhone( entity.getPhone() );
        customerResponse.setProfileImageId( entity.getProfileImageId() );
        customerResponse.setAge( entity.getAge() );
        customerResponse.setStatus( entity.isStatus() );

        return customerResponse;
    }

    @Override
    public Customer toEntity(CustomerResponse toDto) {
        if ( toDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( toDto.getId() );
        customer.setName( toDto.getName() );
        customer.setEmail( toDto.getEmail() );
        customer.setPhone( toDto.getPhone() );
        customer.setProfileImageId( toDto.getProfileImageId() );
        customer.setAge( toDto.getAge() );
        customer.setStatus( toDto.isStatus() );

        return customer;
    }

    @Override
    public List<CustomerResponse> toDto(List<Customer> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CustomerResponse> list = new ArrayList<CustomerResponse>( entity.size() );
        for ( Customer customer : entity ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> toEntity(List<CustomerResponse> toDto) {
        if ( toDto == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( toDto.size() );
        for ( CustomerResponse customerResponse : toDto ) {
            list.add( toEntity( customerResponse ) );
        }

        return list;
    }
}
