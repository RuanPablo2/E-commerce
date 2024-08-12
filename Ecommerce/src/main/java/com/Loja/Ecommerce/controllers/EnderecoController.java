package com.Loja.Ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.Cidade;
import com.Loja.Ecommerce.models.Endereco;
import com.Loja.Ecommerce.models.Estado;
import com.Loja.Ecommerce.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService service;

	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco endereco = service.findById(id);
		return ResponseEntity.ok().body(endereco);
	}

	@PostMapping
	public ResponseEntity<Endereco> insert(@Valid @RequestBody Endereco endereco, Cidade cidade, Estado estado) {
		endereco = service.insert(endereco, cidade, estado);
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Endereco> update(@Valid @RequestBody Endereco endereco) {
		endereco = service.update(endereco);
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}