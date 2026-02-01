package com.bankymono.webflux_proj.sec07;

import com.bankymono.webflux_proj.sec07.dto.Product;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lec04HeaderTest extends AbstractWebClient{

    private final WebClient client = createWebClient(b -> b.defaultHeader("caller-id","order-service"));

    @Test
    public void defaultHeader() {
        this.client.get()
                .uri("/lec04/product/{id}", 1)
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(print())
                .then()
                .as(StepVerifier::create)
                .expectComplete()
                .verify();

    }

    @Test
    public void overrideHeader() {
        this.client.get()
                .uri("/lec04/product/{id}", 1)
                .header("caller-id", "new-value")
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(print())
                .then()
                .as(StepVerifier::create)
                .expectComplete()
                .verify();

    }

    @Test
    public void headersWithMap() {
        var map = Map.of(
                "caller-id", "new-value",
                "some-key", "some-value"
        );

        this.client.get()
                .uri("/lec04/product/{id}", 1)
//                .header("caller-id", "new-value")
                .headers(h -> h.setAll(map))
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(print())
                .then()
                .as(StepVerifier::create)
                .expectComplete()
                .verify();

    }
}
