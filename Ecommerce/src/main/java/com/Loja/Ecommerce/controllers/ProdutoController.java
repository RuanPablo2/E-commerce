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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Loja.Ecommerce.models.Imagens;
import com.Loja.Ecommerce.models.Produto;
import com.Loja.Ecommerce.services.ImagensService;
import com.Loja.Ecommerce.services.ProdutoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	ImagensService imagensService;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> lista = produtoService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}

	@GetMapping("/filtro")
	public ResponseEntity<List<Produto>> FindByNomeContains(@RequestParam("nome") String nome) {
		List<Produto> produto = produtoService.findByNomeProduto(nome);
		return ResponseEntity.ok().body(produto);
	}

	@PostMapping
	public ResponseEntity<Produto> insert(@Valid @RequestBody Produto produto) {
		produto = produtoService.insert(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Produto> update(@Valid @RequestBody Produto produto) {
		produto = produtoService.insert(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/imagens")
	public ResponseEntity<List<Imagens>> findAllImagens() {
		List<Imagens> lista = imagensService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/imagens/{id}")
	public ResponseEntity<Imagens> findImagemById(@PathVariable Long id) {
		Imagens imagem = imagensService.findById(id);
		return ResponseEntity.ok().body(imagem);
	}

	@PostMapping("/imagens")
	public ResponseEntity<Imagens> insertImagem(@Valid @RequestBody Imagens imagem) {
		imagem = imagensService.insert(imagem);
		return new ResponseEntity<Imagens>(imagem, HttpStatus.CREATED);
	}

	@PutMapping("/imagens")
	public ResponseEntity<Imagens> updateImagem(@Valid @RequestBody Imagens imagem) {
		imagem = imagensService.insert(imagem);
		return new ResponseEntity<Imagens>(imagem, HttpStatus.CREATED);
	}

	@DeleteMapping("/imagens/{id}")
	public ResponseEntity<Void> deleteImagem(Long id) {
		imagensService.delete(id);
		return ResponseEntity.noContent().build();
	}
}