package com.bankymono.webflux_proj.sec02;

import com.bankymono.webflux_proj.sec02.dto.OrderDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.test.StepVerifier;

public class Lec04DatabaseClientTest extends AbstractTest{
    private static final Logger log = LoggerFactory.getLogger(Lec04DatabaseClientTest.class);

    @Autowired
    private DatabaseClient client;

    @Test
    public void orderDetailsByProduct() {
        String query = """
                    select
                    co.order_id,
                    c.name as customer_name,
                    p.description as product_name,
                    co.amount,
                    co.order_date
                from
                    customer c
                inner join customer_order co on c.id = co.customer_id
                inner join product p on co.product_id = p.id
                where
                    p.description = :description
                order by co.amount desc
                """;
        this.client.sql(query)
                .bind("description", "iphone 20")
                .mapProperties(OrderDetails.class)
                .all()
                .doOnNext(dto -> log.info("VAL# -> {}", dto))
                .as(StepVerifier::create)
                .assertNext(dto -> Assertions.assertEquals(975, dto.amount()))
                .assertNext(dto -> Assertions.assertEquals(950, dto.amount()))
                .expectComplete()
                .verify();
    }

}
