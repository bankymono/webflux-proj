package com.bankymono.webflux_proj.sec03.mapper;

import com.bankymono.webflux_proj.sec03.entity.Customer;
import com.bankymono.webflux_proj.sec03.dto.CustomerDto;

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
