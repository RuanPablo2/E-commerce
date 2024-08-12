package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.repositories.ClienteRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		try {
			Cliente cliente = repository.findById(id).get();
			return cliente;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Cliente não encontrado para o id:" + id + ", tipo: " + Cliente.class.getName());
		}
	}

	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		try {
			return repository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public Cliente update(Cliente cliente) {
		findById(cliente.getId());
		try {
			return repository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
		}
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir este cliente!");
		}
	}

}