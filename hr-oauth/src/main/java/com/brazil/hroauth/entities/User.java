package com.brazil.hroauth.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private Long ID;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    /**
     * metodo para obter a informação dos tipos de perfil do usuário */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(x -> new SimpleGrantedAuthority(x.getRoleName()))
                .collect(Collectors.toList());
    }

    /**
     * metodo para retornar o nome do usuário*/
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * metodo para testar se a conta do usuário não está expirada */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * metodo para testar se a conta do usuário não esta bloqueada */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * metodo para obter a informação se as credenciais não estão expiradas */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * metodo para obter a informação se o usuário está habilitado */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
