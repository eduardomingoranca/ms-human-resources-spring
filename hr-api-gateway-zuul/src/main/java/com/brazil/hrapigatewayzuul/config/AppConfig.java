package com.brazil.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

    /**
     * convertendo o acesso em Token.*/
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        /**
         * configurando a chave secreta que será assinada os tokens */
        tokenConverter.setSigningKey("MY-SECRET-KEY");
        return tokenConverter;
    }

    /**
     * objeto responsavel por ler as informações do token */
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

}
