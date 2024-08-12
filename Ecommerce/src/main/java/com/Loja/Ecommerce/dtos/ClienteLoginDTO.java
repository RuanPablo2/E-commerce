package com.Loja.Ecommerce.dtos;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.Loja.Ecommerce.models.Cliente;

public class ClienteLoginDTO {
	
	private String email;
	
	private String password;

	public ClienteLoginDTO(Cliente cliente) {
		this.email = cliente.getEmail();
		this.password = cliente.getPassword();
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}