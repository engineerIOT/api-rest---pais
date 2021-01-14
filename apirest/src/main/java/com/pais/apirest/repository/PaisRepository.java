package com.pais.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pais.apirest.models.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{
	Pais findById(long id);
}
