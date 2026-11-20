package com.senai.backend.rental_events.configs;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Rental Events",
        version = "1.0",
        description = "Gerencie equipamentos, usuários e movimentações de locação em um só lugar."
    )
)
public class Swagger {

}