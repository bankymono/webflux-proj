package com.bankymono.webflux_proj.sec06.config;

import com.bankymono.webflux_proj.sec06.exceptions.CustomerNotFoundException;
import com.bankymono.webflux_proj.sec06.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

    @Autowired
    private CustomerRequestHandler requestHandler;

    @Autowired
    private ApplicationExceptionHandler exceptionHandler;


    @Bean
    public RouterFunction<ServerResponse> customRoutes() {
        return RouterFunctions.route()
                .GET("/customers",requestHandler::allCustomers)
                .GET("/customers/paginated",requestHandler::paginatedCustomers)
                .GET("/customers/{id}",requestHandler::getCustomer)
                .POST("/customers",requestHandler::saveCustomer)
                .PUT("/customers/{id}",requestHandler::updateCustomer)
                .DELETE("/customers/{id}",requestHandler::deleteCustomer)
                .onError(CustomerNotFoundException.class, this.exceptionHandler::handleException)
                .onError(InvalidInputException.class, this.exceptionHandler::handleException)
                .build();
    }
}
