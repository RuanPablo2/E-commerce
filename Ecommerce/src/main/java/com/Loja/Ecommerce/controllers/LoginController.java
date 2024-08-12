package com.Loja.Ecommerce.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.dtos.ClienteLoginDTO;
import com.Loja.Ecommerce.dtos.UsuarioLoginDTO;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	AuthenticationManager authManager;
	
	@PostMapping(value = "/cliente", produces = {"application/json"})
	public ResponseEntity<String> loginCliente(@RequestBody @Valid ClienteLoginDTO loginDTO){
		UsernamePasswordAuthenticationToken dadosLogin = loginDTO.converter();
		try {
			authManager.authenticate(dadosLogin);
			return new ResponseEntity<String>("Login efetuado com sucesso!", HttpStatus.OK);
			
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping(value = "/usuario", produces = {"application/json"})
	public ResponseEntity<String> loginUsuario(@RequestBody @Valid UsuarioLoginDTO loginDTO){
		UsernamePasswordAuthenticationToken dadosLogin = loginDTO.converter();
		try {
			authManager.authenticate(dadosLogin);
			return new ResponseEntity<String>("Login efetuado com sucesso!", HttpStatus.OK);
			
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}