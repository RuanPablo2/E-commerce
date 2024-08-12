package com.Loja.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Imagens;

@Repository
public interface ImagensRepository  extends JpaRepository <Imagens, Long> {

}