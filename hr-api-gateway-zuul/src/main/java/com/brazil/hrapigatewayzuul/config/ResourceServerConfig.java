package com.brazil.hrapigatewayzuul.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Resource server >> responsavel por receber requisições do usuário via token e avalia
 * se o usuário tem permissão de acessar o determinado recurso solicitado.
 * classe de configuração para informar que a api gateway zuul será responsavel por ser
 * o resource server das aplicações. */
@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final JwtTokenStore tokenStore;

    /**
     * constante responsavel por receber os caminhos/rotas publicas. */
    private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };

    /**
     * constante responsavel por receber os caminhos/rotas de autorização do operador. */
    private static final String[] OPERATOR = { "/hr-worker/**" };

    /**
     * constante responsavel por receber os caminhos/rotas de autorização do administrador. */
    private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };

    /**
     * metodo responsavel para que a aplicação consiga ser o token. */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    /**
     * metodo de configuração das autorizações */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll() /** antMatchers >> metodo que define as rotas de autorização. */
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN).hasRole("ADMIN") /** hasRole, hasAnyRole >> metodo para receber os papeis de permissão. */
                .anyRequest().authenticated();
    }

}
