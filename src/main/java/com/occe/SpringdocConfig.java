package com.occe;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.annotations.info.License;




@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "API REST \"OCCE\"",
        description = "Esta es una API REST para realizar operaciones en el sistema de ORIENTACION CURRICULAR PARA CORDINADORES Y ESTUDIANTES \"OCCE\". El propósito principal de esta API REST desarrollada con Spring es proporcionar una interfaz de programación de aplicaciones (API) basada en los principios y estándares de REST (Representational State Transfer). La API REST de Spring permite la comunicación y transferencia de datos entre diferentes aplicaciones y sistemas de manera eficiente y escalable. Al utilizar Spring Boot, se simplifica el proceso de desarrollo de la API, ya que proporciona un marco de trabajo sólido y herramientas integradas para crear endpoints HTTP",
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