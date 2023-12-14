package com.semana7.swagger.dao;

import com.semana7.swagger.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroDAO extends JpaRepository<LibroEntity,Long> {
}
