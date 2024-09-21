package com.riwi.VorteXtream_BACK_END_SpringBoot.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "vorteXtream",
        version = "1.0.0",
        description = "This is my stream Riwi project backend, to manage admin routes"
))
public class OpenApiConfig {
}
