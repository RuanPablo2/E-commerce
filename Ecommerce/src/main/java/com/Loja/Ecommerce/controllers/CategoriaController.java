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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.Categoria;
import com.Loja.Ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}

	@GetMapping("/filtro")
	public ResponseEntity<List<Categoria>> FindByNomeContains(@RequestParam("nome") String nome) {
		List<Categoria> categoria = service.findByNomeCategoria(nome);
		return ResponseEntity.ok().body(categoria);
	}

	@PostMapping
	public ResponseEntity<Categoria> insert(@Valid @RequestBody Categoria categoria) {
		categoria = service.insert(categoria);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Categoria> update(@Valid @RequestBody Categoria categoria) {
		categoria = service.insert(categoria);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}