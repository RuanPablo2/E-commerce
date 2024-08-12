package com.Loja.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Loja.Ecommerce.models.Roles;

@Repository
public interface RolesRepository  extends JpaRepository <Roles, Long> {

}