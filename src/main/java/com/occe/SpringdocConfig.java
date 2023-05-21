package com.occe;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.annotations.info.License;




@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "API REST \"OCCE\"",
        description = "Esta es una API REST para realizar operaciones en el sistema de ORIENTACION CURRICULAR PARA CORDINADORES Y ESTUDIANTES\n \"OCCE\"",
        version = "1.0.0",
        license = @License(
            name = "Licencia Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html")
    )
)
@Configuration
public class SpringdocConfig {

    // Configuración adicional de Springdoc
    
}