package com.bankymono.webflux_proj.sec09.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@ToString
public class Product {
    @Id
    private Integer id;
    private String description;
    private Integer price;
}
