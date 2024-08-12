package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Categoria;
import com.Loja.Ecommerce.repositories.CategoriaRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria findById(Long id) {
		try {
			Categoria categoria = repository.findById(id).get();
			return categoria;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Categoria não encontrada para o id:" + id + ", tipo: " + Categoria.class.getName());
		}
	}

	public Categoria insert(Categoria categoria) {
		categoria.setIdCategoria(null);
		try {
			return repository.save(categoria);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public Categoria update(Categoria categoria) {
		findById(categoria.getIdCategoria());
		try {
			return repository.save(categoria);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir esta categoria!");
		}
	}
	
	public List<Categoria> findByNomeCategoria(String nome) {
        return repository.findByNomeContains(nome);
    }

}
