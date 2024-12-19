package com.waveghost.uwhub.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "UWHub API", version = "1.0", description = "Api of the UWHub project for the management of athletes, clubs and tournaments."))
public class OpenApiConfig {
    
}
