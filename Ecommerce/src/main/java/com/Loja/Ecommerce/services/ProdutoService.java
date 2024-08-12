package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Produto;
import com.Loja.Ecommerce.repositories.ProdutoRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		try {
			Produto produto = repository.findById(id).get();
			return produto;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Produto não encontrado para o id:" + id + ".");
		}
	}

	public Produto insert(Produto produto) {
		produto.setIdProduto(null);;
		try {
			return repository.save(produto);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public Produto update(Produto produto) {
		findById(produto.getIdProduto());
		try {
			return repository.save(produto);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este produto!");
		}
	}
	
	public List<Produto> findByNomeProduto(String nome) {
        return repository.findByNomeContains(nome);
    }
}