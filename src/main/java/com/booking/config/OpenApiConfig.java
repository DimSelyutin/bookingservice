package com.booking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * * OpenAPI configuration.
 */
@Configuration
public class OpenApiConfig implements WebMvcConfigurer {

    private final BuildProperties buildProperties;

    public OpenApiConfig(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    /**
     * The OpenAPI bin.
     *
     * @return of the configured OpenAPI
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hotel booking service.")
                        .version(buildProperties.getVersion())
                        .description(
                                "Hotel search and booking service."));
    }

}
