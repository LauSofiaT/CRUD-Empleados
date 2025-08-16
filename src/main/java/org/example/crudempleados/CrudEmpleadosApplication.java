package org.example.crudempleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class CrudEmpleadosApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudEmpleadosApplication.class, args);
    }
    @Bean
    public CommandLineRunner listarRutas(ApplicationContext ctx) {
        return args -> {
            RequestMappingHandlerMapping mapping = ctx.getBean(RequestMappingHandlerMapping.class);
            mapping.getHandlerMethods().forEach((key, value) ->
                    System.out.println(key + " : " + value)
            );
        };
    }
}

