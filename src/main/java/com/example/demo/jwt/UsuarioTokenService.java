package com.example.demo.jwt;

import com.example.demo.models.dao.IUsuarioTokenDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioTokenService implements UserDetailsService {
    private final IUsuarioTokenDao iUsuarioTokenDao;

    public UsuarioTokenService(IUsuarioTokenDao iUsuarioTokenDao) {
        this.iUsuarioTokenDao = iUsuarioTokenDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return iUsuarioTokenDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}
