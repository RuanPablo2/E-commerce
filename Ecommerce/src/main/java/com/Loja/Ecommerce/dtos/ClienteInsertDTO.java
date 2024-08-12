package com.Loja.Ecommerce.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInsertDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String email;
	
	private String password;
	
	private String CpfOuCnpj;
	
	private Integer tipo;

	private String telefone;
}