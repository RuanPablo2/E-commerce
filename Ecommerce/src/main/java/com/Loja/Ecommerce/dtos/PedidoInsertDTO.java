package com.Loja.Ecommerce.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.Loja.Ecommerce.models.ItemPedido;

import lombok.Data;

@Data
public class PedidoInsertDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCliente;
	
	private Double total;
	
	private LocalDateTime dataHora;
	
	private List<ItemPedido> produtos;
}