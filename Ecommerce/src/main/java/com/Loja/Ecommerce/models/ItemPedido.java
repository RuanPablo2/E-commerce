package com.Loja.Ecommerce.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	@NotNull(message = "A quantidade do item do pedido deve ser preenchida!")
    @Digits(integer=8, fraction=0, message = "A quantidade do item do pedido deve ser preenchido SEM dígitos!")
	private Integer quantidade;

	@NotNull(message = "O valor do item do pedido deve ser preenchido!")
    @Digits(integer=8, fraction=2, message = "O valor do item do pedido deve ser preenchido com dígitos!")
	private Double preco;

	private Double desconto;

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco, Double desconto) {
		this.id.setPedido(pedido);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

//	Getter de produto id para ter acesso a ela fora da classe original
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
        id.setProduto(produto);
    }
}