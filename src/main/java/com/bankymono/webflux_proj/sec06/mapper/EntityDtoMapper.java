package com.bankymono.webflux_proj.sec06.mapper;

import com.bankymono.webflux_proj.sec06.dto.CustomerDto;
import com.bankymono.webflux_proj.sec06.entity.Customer;

public class EntityDtoMapper {

    public static Customer toEntity(CustomerDto dto) {
        var customer = new Customer();
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        customer.setId(dto.id());

        return customer;
    }

    public static CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getEmail());
    }
}
