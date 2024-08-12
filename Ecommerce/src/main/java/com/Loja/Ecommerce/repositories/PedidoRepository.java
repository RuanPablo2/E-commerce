package com.Loja.Ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Loja.Ecommerce.models.Cliente;
import com.Loja.Ecommerce.models.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository <Pedido, Long> {

	@Transactional(readOnly = true)
	List<Pedido> findByIdCliente(Cliente cliente);
}