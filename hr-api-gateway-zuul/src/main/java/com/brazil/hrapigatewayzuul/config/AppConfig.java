package com.brazil.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * annotation responsavel de atualizar os valores das variáveis
 * tempo de execução com o actuator. */
@RefreshScope
@Configuration
public class AppConfig {

    /**
     * recebendo a propriedade no arquivo properties. */
    @Value("${jwt.secret}")
    private String jwtSecret;

    /**
     * convertendo o acesso em Token.*/
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        /**
         * configurando a chave secreta que será assinada os tokens */
        tokenConverter.setSigningKey(jwtSecret);
        return tokenConverter;
    }

    /**
     * objeto responsavel por ler as informações do token */
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

}
