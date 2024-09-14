package com.linguish.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info =  @Info(
        title = "Api de Ingles",
        description = "La siguiente api muestra los endpoints a trabajar sobre el sistema"
    ), 
    servers = {
        @Server(
        url =  "https://linguish.up.railway.app", 
        description = "DEV-SERVER"
        )
    }
)
public class SwaggerConfig {

}