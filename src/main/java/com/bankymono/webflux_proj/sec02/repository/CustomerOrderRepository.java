package com.bankymono.webflux_proj.sec02.repository;

import com.bankymono.webflux_proj.sec02.dto.OrderDetails;
import com.bankymono.webflux_proj.sec02.entity.CustomerOrder;
import com.bankymono.webflux_proj.sec02.entity.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CustomerOrderRepository extends ReactiveCrudRepository<CustomerOrder, UUID> {
    @Query("""
            SELECT
                p.*
             FROM
                customer c
                INNER JOIN customer_order co ON c.id = co.customer_id
                INNER JOIN product p ON co.product_id = p.id
             WHERE
                c.name = :name
            """)
    Flux<Product> getProductsOrderedByCustomer(String name);

    @Query("""
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
            """)
    Flux<OrderDetails> getOrderDetailsByProduct(String description);
}
