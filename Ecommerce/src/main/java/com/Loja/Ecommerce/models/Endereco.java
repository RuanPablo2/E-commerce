package com.Loja.Ecommerce.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O logradouro deve ser informado!")
	private String logradouro;
	
	@Digits(integer=4, fraction=0, message = "O número da casa deve ser preenchido com um valor inteiro!")
	private Integer numero;
	
	private String complemento;
	
	@NotBlank(message = "O bairro deve ser informado!")
	private String bairro;
	
	@NotBlank(message = "O CEP deve ser informado!")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;	
}