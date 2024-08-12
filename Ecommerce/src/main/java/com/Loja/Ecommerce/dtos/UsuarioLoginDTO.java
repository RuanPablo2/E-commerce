package com.Loja.Ecommerce.dtos;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.Loja.Ecommerce.models.Usuario;

public class UsuarioLoginDTO {
	
	private String email;
	
	private String password;

	public UsuarioLoginDTO(Usuario usuario) {
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}