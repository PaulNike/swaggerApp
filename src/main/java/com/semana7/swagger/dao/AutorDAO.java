package com.semana7.swagger.dao;

import com.semana7.swagger.entity.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorDAO extends JpaRepository<AutorEntity,Long> {
}
