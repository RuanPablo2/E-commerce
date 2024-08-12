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
import com.Loja.Ecommerce.services.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	CidadeService service;

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade cidade = service.findById(id);
		return ResponseEntity.ok().body(cidade);
	}

	@PostMapping
	public ResponseEntity<Cidade> insert(@Valid @RequestBody Cidade cidade) {
		cidade = service.insert(cidade);
		return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Cidade> update(@Valid @RequestBody Cidade cidade) {
		cidade = service.insert(cidade);
		return new ResponseEntity<Cidade>(cidade, HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
