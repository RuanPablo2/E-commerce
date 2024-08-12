package com.Loja.Ecommerce.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.repositories.ClienteRepository;

@Service
@Transactional
public class ClienteDetailsImpl implements UserDetailsService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = clienteRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado para o email: " + email));
		return new User(cliente.getEmail(), cliente.getPassword(), true, true, true, true, cliente.getAuthorities());
	}
}