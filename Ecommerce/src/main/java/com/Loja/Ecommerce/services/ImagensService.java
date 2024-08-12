package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Imagens;
import com.Loja.Ecommerce.repositories.ImagensRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class ImagensService {
	
	@Autowired
	ImagensRepository repository;

	public List<Imagens> findAll() {
	    return repository.findAll();
	}

	public Imagens findById(Long id) {
	    try {
	        Imagens imagem = repository.findById(id).get();
	        return imagem;
	    } catch (NotFoundException e) {
	        throw new ObjectNotFoundException("Imagens não encontrado para o id:" + id + ", tipo: " + Imagens.class.getName());
	    }
	}

	public Imagens insert(Imagens imagem) {
	    imagem.setIdImagem(null);
	    try {
	        return repository.save(imagem);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public Imagens update(Imagens imagem) {
	    findById(imagem.getIdImagem());
	    try {
	        return repository.save(imagem);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public void delete(Long id) {
	    findById(id);
	    try {
	        repository.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Não é possível excluir este imagem!");
	    }
	}
}
