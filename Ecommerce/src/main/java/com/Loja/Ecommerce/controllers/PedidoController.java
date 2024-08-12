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

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.models.Pedido;
import com.Loja.Ecommerce.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService service;

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id) {
		Pedido pedido = service.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<List<Pedido>> FindByNomeContains(@PathVariable Long idCliente) {
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		List<Pedido> pedidos = service.findByCliente(cliente);
		return ResponseEntity.ok().body(pedidos);
	}

	@PostMapping
	public ResponseEntity<Pedido> insert(@Valid @RequestBody Pedido pedido) {
		pedido = service.insert(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Pedido> update(@Valid @RequestBody Pedido pedido) {
		pedido = service.insert(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
