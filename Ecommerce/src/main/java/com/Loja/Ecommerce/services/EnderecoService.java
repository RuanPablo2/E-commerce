package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Cidade;
import com.Loja.Ecommerce.models.Endereco;
import com.Loja.Ecommerce.models.Estado;
import com.Loja.Ecommerce.repositories.CidadeRepository;
import com.Loja.Ecommerce.repositories.EnderecoRepository;
import com.Loja.Ecommerce.repositories.EstadoRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public List<Endereco> findAll() {
	    return enderecoRepository.findAll();
	}

	public Endereco findById(Long id) {
	    try {
	        Endereco endereco = enderecoRepository.findById(id).get();
	        return endereco;
	    } catch (NotFoundException e) {
	        throw new ObjectNotFoundException("Endereco não encontrado para o id:" + id + ", tipo: " + Endereco.class.getName());
	    }
	}

	public Endereco insert(Endereco endereco, Cidade cidade, Estado estado) {
	    try {
		    endereco.setId(null);
	    	estado.setId(null);
	    	cidade.setId(null);
	    	estadoRepository.save(estado);
	    	cidade.setEstado(estado);
	    	cidadeRepository.save(cidade);
	    	endereco.setCidade(cidade);
	        return enderecoRepository.save(endereco);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public Endereco update(Endereco endereco) {
	    findById(endereco.getId());
	    try {
	        return enderecoRepository.save(endereco);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Os campos não foram preenchidos corretamente!");
	    }
	}

	public void delete(Long id) {
	    findById(id);
	    try {
	        enderecoRepository.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DataIntegrityException("Não é possível excluir este endereco!");
	    }
	}
}