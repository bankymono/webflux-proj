package com.bankymono.webflux_proj.sec07;

import com.bankymono.webflux_proj.sec07.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

public class Lec07BasicAuthTest extends AbstractWebClient{

    private final WebClient client = createWebClient(b -> b.defaultHeaders(h-> h.setBasicAuth("java", "secret")));

    @Test
    public void basicAuth() {
        this.client.get()
                .uri("/lec07/product/{id}", 1)
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(print())
                .then()
                .as(StepVerifier::create)
                .expectComplete()
                .verify();
    }



}
