package com.module.Sistema.services;

import com.module.Sistema.entities.Usuario;
import com.module.Sistema.repositories.Iusuario;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Presentacion
 */
@Service("usuarioDetailsService")
public class UsuarioDetailsService implements UserDetailsService{
    @Autowired
    private Iusuario iusuarios;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuarios = iusuarios.findByUser(username);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(usuarios.getRol()));
        return new User(username,usuarios.getPassword(),authorities);
    }
}
