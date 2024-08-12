package com.Loja.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.models.ItemPedido;
import com.Loja.Ecommerce.models.Pedido;
import com.Loja.Ecommerce.repositories.PedidoRepository;
import com.Loja.Ecommerce.repositories.ProdutoRepository;
import com.Loja.Ecommerce.services.exceptions.DataIntegrityException;
import com.Loja.Ecommerce.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Pedido> findAll() {
		List<Pedido> lista = pedidoRepository.findAll();
		return lista;
	}

	public Pedido findById(Long id) {
		try {
			Pedido pedido = pedidoRepository.findById(id).get();
			return pedido;
		} catch (NotFoundException e) {
			throw new ObjectNotFoundException("Pedido não encontrado para o número:" + id + ", tipo: " + Pedido.class.getName());
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // Esta notação tem objetivo de controlar a propagação da transação (garantindo que sejam realizadas todas as modificações no BD, ou nada)
	public Pedido insert(Pedido pedido) {
		try {
			pedido.setIdPedido(null);
			for (ItemPedido item : pedido.getItem()) {
				item.setPedido(pedido);
				item.getProduto();
				produtoRepository.save(item.getProduto());
			}
			return pedidoRepository.save(pedido);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do pedido não foi(foram) preenchido(s): Cliente ou itens do pedido!");
		}
	}

	public Pedido update(Pedido pedido) {
		try {
			findById(pedido.getIdPedido());
			for (ItemPedido item : pedido.getItem()) {
				item.setPedido(pedido);
				item.getProduto();
				produtoRepository.save(item.getProduto());
			}
			return pedidoRepository.save(pedido);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Campo(s) obrigatório(s) do pedido não foi(foram) preenchido(s): Cliente ou itens do pedido!");
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // Todas as operações de persistência no BD serão realizadas em uma única transação (se tudo der certo commit, senão rollback em tudo).
	public void delete(Long id) {
		findById(id);
		try {
			pedidoRepository.deleteById(id);
			pedidoRepository.flush(); // Forçando a sincronização da(s) alteração(ões) e remoção neste momento (assim, diante de qualquer problema, o catch conseguirá capturar a exceção nesta camada de serviço)
			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir esse pedido!");
		}
	}

	public List<Pedido> findByCliente(Cliente cliente) {
		return pedidoRepository.findByIdCliente(cliente);
	}
}