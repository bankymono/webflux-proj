package com.bankymono.webflux_proj.sec03.repository;

import com.bankymono.webflux_proj.sec03.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {

}
