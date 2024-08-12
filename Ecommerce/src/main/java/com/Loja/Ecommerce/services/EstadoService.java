package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Estado;
import com.Loja.Ecommerce.repositories.EstadoRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service	
public class EstadoService {
	
	@Autowired
	EstadoRepository repository;
	
	public List<Estado> findAll() {
	    return repository.findAll();
	}

	public Estado findById(Long id) {
	    try {
	        Estado estado = repository.findById(id).get();
	        return estado;
	    } catch (NotFoundException e) {
	        throw new ObjectNotFoundException("Estado não encontrado para o id:" + id + ", tipo: " + Estado.class.getName());
	    }
	}

	public Estado insert(Estado estado) {
	    estado.setId(null);
	    try {
	        return repository.save(estado);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public Estado update(Estado estado) {
	    findById(estado.getId());
	    try {
	        return repository.save(estado);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public void delete(Long id) {
	    findById(id);
	    try {
	        repository.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Não é possível excluir este estado!");
	    }
	}
}