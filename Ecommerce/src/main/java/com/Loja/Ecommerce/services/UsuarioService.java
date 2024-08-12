package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Usuario;
import com.Loja.Ecommerce.repositories.UsuarioRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public List<Usuario> findAll() {
	    return repository.findAll();
	}

	public Usuario findById(Long id) {
	    try {
	        Usuario usuario = repository.findById(id).get();
	        return usuario;
	    } catch (NotFoundException e) {
	        throw new ObjectNotFoundException("Usuario não encontrado para o id:" + id + ", tipo: " + Usuario.class.getName());
	    }
	}

	public Usuario insert(Usuario usuario) {
	    usuario.setIdUsuario(null);
	    try {
	        return repository.save(usuario);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public Usuario update(Usuario usuario) {
	    findById(usuario.getIdUsuario());
	    try {
	        return repository.save(usuario);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public void delete(Long id) {
	    findById(id);
	    try {
	        repository.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Não é possível excluir este usuario!");
	    }
	}
}
