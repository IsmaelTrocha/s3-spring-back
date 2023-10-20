package com.fullstack.s3.infrastructure.mapper;

import com.fullstack.s3.domain.entities.Customer;
import com.fullstack.s3.infrastructure.repository.CustomerDto;
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
public class CustomerDtoMapperImpl implements CustomerDtoMapper {

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( entity.getId() );
        customerDto.setName( entity.getName() );
        customerDto.setEmail( entity.getEmail() );
        customerDto.setPassword( entity.getPassword() );
        customerDto.setPhone( entity.getPhone() );
        customerDto.setProfileImageId( entity.getProfileImageId() );
        customerDto.setAge( entity.getAge() );
        customerDto.setStatus( entity.isStatus() );

        return customerDto;
    }

    @Override
    public Customer toEntity(CustomerDto toDto) {
        if ( toDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( toDto.getId() );
        customer.setName( toDto.getName() );
        customer.setEmail( toDto.getEmail() );
        customer.setPassword( toDto.getPassword() );
        customer.setPhone( toDto.getPhone() );
        customer.setProfileImageId( toDto.getProfileImageId() );
        customer.setAge( toDto.getAge() );
        customer.setStatus( toDto.isStatus() );

        return customer;
    }

    @Override
    public List<CustomerDto> toDto(List<Customer> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( entity.size() );
        for ( Customer customer : entity ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public List<Customer> toEntity(List<CustomerDto> toDto) {
        if ( toDto == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( toDto.size() );
        for ( CustomerDto customerDto : toDto ) {
            list.add( toEntity( customerDto ) );
        }

        return list;
    }
}
