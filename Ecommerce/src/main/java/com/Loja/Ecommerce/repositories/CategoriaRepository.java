package com.Loja.Ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository <Categoria, Long> {

	List<Categoria> findByNomeContains(String nome);

}