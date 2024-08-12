package com.Loja.Ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.Usuario;
import com.Loja.Ecommerce.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(usuario);
    }
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@Valid @RequestBody Usuario usuario){
		String senhaCriptografa = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(senhaCriptografa);
		return new ResponseEntity<Usuario>(service.insert(usuario), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario){
		String senhaCriptografa = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(senhaCriptografa);
		return new ResponseEntity<Usuario>(service.update(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
