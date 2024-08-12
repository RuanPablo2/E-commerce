package com.Loja.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}