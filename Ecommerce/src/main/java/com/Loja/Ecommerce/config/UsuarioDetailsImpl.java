package com.Loja.Ecommerce.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Loja.Ecommerce.models.Usuario;
import com.Loja.Ecommerce.repositories.UsuarioRepository;

@Service
@Transactional
public class UsuarioDetailsImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado para o username: " + email));
		return new User(usuario.getEmail(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
}