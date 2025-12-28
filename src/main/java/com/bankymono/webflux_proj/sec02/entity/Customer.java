package com.bankymono.webflux_proj.sec02.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Customer {

    @Id
    private int id;
    private String name;
    private String email;
}
