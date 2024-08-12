package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Cidade;
import com.Loja.Ecommerce.repositories.CidadeRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository repository;
	
	public List<Cidade> findAll() {
	    return repository.findAll();
	}

	public Cidade findById(Long id) {
	    try {
	        Cidade cidade = repository.findById(id).get();
	        return cidade;
	    } catch (NotFoundException e) {
	        throw new ObjectNotFoundException("Cidade não encontrado para o id:" + id + ", tipo: " + Cidade.class.getName());
	    }
	}

	public Cidade insert(Cidade cidade) {
	    cidade.setId(null);
	    try {
	        return repository.save(cidade);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public Cidade update(Cidade cidade) {
	    findById(cidade.getId());
	    try {
	        return repository.save(cidade);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public void delete(Long id) {
	    findById(id);
	    try {
	        repository.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Não é possível excluir este cidade!");
	    }
	}
}