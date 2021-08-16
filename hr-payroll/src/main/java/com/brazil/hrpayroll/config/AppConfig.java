package com.brazil.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    /**
     * metodo que registra um instancia única
     * de um objeto do tipo RestTemplate, e esta
     * instancia única vai ficar disponivel para
     * injetar em outros componentes. */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
