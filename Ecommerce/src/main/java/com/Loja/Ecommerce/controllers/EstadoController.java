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

import com.Loja.Ecommerce.models.Estado;
import com.Loja.Ecommerce.services.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	
	@Autowired
	EstadoService service;

	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		Estado estado = service.findById(id);
		return ResponseEntity.ok().body(estado);
	}

	@PostMapping
	public ResponseEntity<Estado> insert(@Valid @RequestBody Estado estado) {
		estado = service.insert(estado);
		return new ResponseEntity<Estado>(estado, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Estado> update(@Valid @RequestBody Estado estado) {
		estado = service.update(estado);
		return new ResponseEntity<Estado>(estado, HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
