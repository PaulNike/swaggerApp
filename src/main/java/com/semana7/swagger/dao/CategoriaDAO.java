package com.semana7.swagger.dao;

import com.semana7.swagger.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<CategoriaEntity,Long> {
}
